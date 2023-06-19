package telran.cars.model;

import telran.cars.dto.*;
import telran.cars.utils.Persistable;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.spi.LocaleServiceProvider;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable {
    private static final int REMOVE_THRESHOLD = 60;
    private static final int BAD_THRESHOLD = 30;
    private static final int GOOD_THRESHOLD = 10;
    //sprint 1
    HashMap<String, Car> cars = new HashMap<>();
    HashMap<Long, Driver> drivers = new HashMap<>();
    HashMap<String, Model> models = new HashMap<>();
    //sprint 2
    TreeMap<LocalDate, List<RentRecord>> records = new TreeMap<>();
    HashMap<Long, List<RentRecord>> driverRecords = new HashMap<>();
    HashMap<String, List<RentRecord>> carRecords = new HashMap<>();
    HashMap<String, List<Car>> modelCars = new HashMap<>();


    @Override
    public void save(String fileName) throws IOException {
        try( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(this);
        } catch (Exception e){
            System.out.println("Error in save method " + e.getMessage());
        }
    }
    public static RentCompanyEmbedded restoreFromFile(String fileName){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            return (RentCompanyEmbedded) in.readObject();
        }catch (Exception e){
            return new RentCompanyEmbedded();
        }
    }

    @Override
    public CarsReturnCode addCar(Car car) {
        if(!models.containsKey(car.getModelName())){
            return CarsReturnCode.NO_MODEL;
        }
        boolean res = cars.put(car.getRegNumber(), car) == null;
        if(!res){
            return CarsReturnCode.CAR_EXISTS;
        }
        addToModelCars(car);
        return CarsReturnCode.OK;
    }

    private void addToModelCars(Car car) {
        String modelName = car.getModelName();
        List<Car> list = modelCars.getOrDefault(modelName, new ArrayList<>());
        list.add(car);
        modelCars.putIfAbsent(modelName, list);
    }

    @Override
    public CarsReturnCode addDriver(Driver driver) {
        return drivers.putIfAbsent(driver.getLicenceId(), driver) == null ? CarsReturnCode.OK : CarsReturnCode.DRIVER_EXISTS;
    }

    @Override
    public CarsReturnCode addModel(Model model) {
        return models.putIfAbsent(model.getModelName(), model) ==  null  ? CarsReturnCode.OK : CarsReturnCode.MODEL_EXISTS;
    }

    @Override
    public Car getCar(String regNumber) {
        return cars.get(regNumber);
    }

    @Override
    public Model getModel(String modelName) {
        return models.get(modelName);
    }

    @Override
    public Driver getDriver(long licenceId) {
        return drivers.get(licenceId);
    }

    @Override
    public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
        Car car = getCar(regNumber);
        if(car == null) {
            return CarsReturnCode.NO_CAR;
        }
        if(car.isFlRemoved()) {
            return CarsReturnCode.CAR_REMOVED;
        }
        if(car.isInUse()){
            return CarsReturnCode.CAR_IN_USE;
        }
        if(!drivers.containsKey(licenseId)){
            return CarsReturnCode.NO_DRIVER;
        }
        RentRecord record = new RentRecord(regNumber, licenseId, rentDate, rentDays);
        addtoCarRecords(record);
        addToDriverRecords(record);
        addToRecords(record);
        car.setInUse(true);
        return CarsReturnCode.OK;
    }

    private void addToDriverRecords(RentRecord record) {
        long licenseId = record.getLicenseId();
        List<RentRecord> list = driverRecords.getOrDefault(licenseId, new ArrayList<>());
        list.add(record);
        driverRecords.putIfAbsent(licenseId, list);
    }

    private void addToRecords(RentRecord record) {
        LocalDate date = record.getRentDate();
        List<RentRecord> list = records.getOrDefault(date, new ArrayList<>());
        list.add(record);
        records.putIfAbsent(date, list);
    }

    private void addtoCarRecords(RentRecord record) {
        String regNumber = record.getRegNumber();
        List<RentRecord> list = carRecords.getOrDefault(regNumber, new ArrayList<>());
        list.add(record);
        carRecords.putIfAbsent(regNumber, list);
    }

    @Override
    public List<Car> getCarsByDriver(long licenseId) {
        List<RentRecord> list = driverRecords.getOrDefault(licenseId, new ArrayList<>());
        return list.stream()
                .map(rr -> getCar(rr.getRegNumber()))
                .distinct()
                .toList();
    }

    @Override
    public List<Driver> getDriversByCar(String regNumber) {
        List<RentRecord> list = carRecords.getOrDefault(regNumber, new ArrayList<>());
        return list.stream()
                .map(rr -> getDriver(rr.getLicenseId()))
                .distinct()
                .toList();
    }

    @Override
    public List<Car> getCarsByModel(String modelName) {
        return modelCars.getOrDefault(modelName, new ArrayList<>()).stream().filter(c -> !c.isFlRemoved() && !c.isInUse()).toList();
    }

    @Override
    public List<RentRecord> getRentRecordsAtDate(LocalDate fromDate, LocalDate toDate) {
        Collection<List<RentRecord>> col = records.subMap(fromDate, toDate).values();
        return col.stream()
                .flatMap(Collection::stream).toList();
    }

//sprint 3
    @Override
    public RemovedCarData removeCar(String regNumber) {
        Car car = getCar(regNumber);
        if( car == null ){
            return null;
        }
        car.setFlRemoved(true);
        return car.isInUse() ? new RemovedCarData(car, null) : actualCarRemove(car);
    }

    private RemovedCarData actualCarRemove(Car car) {
        String regNumber = car.getRegNumber();
        List<RentRecord> list = carRecords.get(regNumber);
        cars.remove(regNumber);
        carRecords.remove(regNumber);
        removeFromDriverRecords(list);
        removeFromRecords(list);
        removeFromModelCars(car);
        return new RemovedCarData(car, list);
    }

    private void removeFromModelCars(Car car) {
        modelCars.get(car.getModelName()).remove(car);
    }

    private void removeFromRecords(List<RentRecord> list) {
        list.forEach(rr -> records.get(rr.getRentDate()).remove(rr));
    }

    private void removeFromDriverRecords(List<RentRecord> list) {
        list.forEach(rr -> driverRecords.get(rr.getLicenseId()).remove(rr));
    }

    @Override
    public List<RemovedCarData> removeCarsOfModel(String modelName) {
        List<Car> list = modelCars.get(modelName);
        if(!list.isEmpty()){
            return list.stream()
                    .map(c -> removeCar(c.getRegNumber()))
                    .toList();
        }
        return new ArrayList<>();
    }

    @Override
    public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent) {
        RentRecord record = driverRecords.get(licenseId)
                .stream()
                .filter(rr -> rr.getRegNumber().equals(regNumber) && rr.getReturnDate() == null)
                .findFirst()
                .orElse(null);
        if(record == null){
            return null;
        }
        updateRecord(record, returnDate, damages, tankPercent);
        Car car = getCar(regNumber);
        updateCar(car, damages);
        return car.isFlRemoved() || damages > REMOVE_THRESHOLD ? actualCarRemove(car) : new RemovedCarData(car, null);
    }
    private void updateCar(Car car, int damages) {
        car.setInUse(false);
        if(damages >= BAD_THRESHOLD){
            car.setState(State.BAD);
        } else if (damages >= GOOD_THRESHOLD){
            car.setState(State.GOOD);
        }
    }

    private void updateRecord(RentRecord record, LocalDate returnDate, int damages, int tankPercent) {
        record.setDamages(damages);
        record.setReturnDate(returnDate);
        record.setTankPercent(tankPercent);
        double cost = computeCost(getRentPrice(record.getRegNumber()), record.getRentDays(), getDelay(record), tankPercent, getTankVolume(record.getRegNumber()));
        record.setCost(cost);

    }

    private int getRentPrice(String regNumber){
        String modelName = cars.get(regNumber).getModelName();
        return models.get(modelName).getPriceDay();
    }


    private int getDelay(RentRecord record){
        long realDays = ChronoUnit.DAYS.between(record.getRentDate(), record.getReturnDate());
        int delta = (int) (realDays - record.getRentDays());
        return delta < 0 ? 0 : delta;
    }

    private int getTankVolume(String regNumber){
        String modelName = cars.get(regNumber).getModelName();
        return models.get(modelName).getPriceDay();
    }
    // sprint 4

    @Override
    public List<String> getMostPopularCarModels(LocalDate dataFrom, LocalDate dataTo, int ageFrom, int ageTo) {
        List<RentRecord> list = getRentRecordsAtDate(dataFrom, dataTo);
        Map<String, Long> map = list.stream().filter(rr -> isProperAge(rr, ageFrom, ageTo))
                .collect(Collectors.groupingBy(rr -> getCar(rr.getRegNumber()).getModelName(), Collectors.counting()));
        long max = Collections.max(map.values());
        List<String> models = new ArrayList<>();
        map.forEach((k, v) -> {
            if(v == max){
                models.add(k);
            }
        });
        return models;
    }
    public boolean isProperAge(RentRecord rr, int ageFrom, int ageTo){
        LocalDate rentDate = rr.getRentDate();
        int birthYear= getDriver(rr.getLicenseId()).getBirthYear();
        int age = rentDate.getYear() - birthYear;
        return age > ageFrom && age <= ageTo;
    }


    @Override
    public List<String> getMostProfitableCarModels(LocalDate dataFrom, LocalDate dataTo) {
        List<RentRecord> list = getRentRecordsAtDate(dataFrom, dataTo);
        if(list.isEmpty()){
            return  new ArrayList<>();
        }
        Map<String, Double> map = list.stream()
                .collect(Collectors.groupingBy(rr -> getCar(rr.getRegNumber()).getModelName(),
                        Collectors.summingDouble(RentRecord::getCost)));
        double max = map.values().stream().mapToDouble(c -> c).max().getAsDouble();
        List<String> models = new ArrayList<>();
        map.forEach((k,v) -> {
            if(v == max){
                models.add(k);
            }
        });
        return models;
    }

    @Override
    public List<Driver> getMostActiveDrivers() {
        long max = driverRecords.values()
                .stream().mapToLong(l -> l.size())
                .max().getAsLong();
        List<Driver> res = new ArrayList<>();
        driverRecords.forEach((k, v) -> {
            if(v.size() == max){
                res.add(getDriver(k));
            }
        });
        return res;
    }



}
