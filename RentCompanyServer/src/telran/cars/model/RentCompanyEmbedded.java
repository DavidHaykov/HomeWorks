package telran.cars.model;


import telran.cars.dto.*;
import telran.cars.utils.Persistable;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import static telran.cars.model.RentCompanyLocks.*;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable, Serializable {
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
        lockUnlock_save(true);
        try( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(this);
        } catch (Exception e){
            System.out.println("Error in save method " + e.getMessage());
        } finally {
            lockUnlock_save(false);
        }
    }
    public static IRentCompany restoreFromFile(String fileName){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            return (IRentCompany) in.readObject();
        }catch (Exception e){
            return new RentCompanyEmbedded();
        }
    }

    @Override
    public CarsReturnCode addCar(Car car) {
        lockUnlock_addCar(true);
        try {
            if (!models.containsKey(car.getModelName())) {
                return CarsReturnCode.NO_MODEL;
            }
            boolean res = cars.put(car.getRegNumber(), car) == null;
            if (!res) {
                return CarsReturnCode.CAR_EXISTS;
            }
            addToModelCars(car);
            return CarsReturnCode.OK;
        }
        finally {
            lockUnlock_addCar(false);
        }
    }

    private void addToModelCars(Car car) {
        String modelName = car.getModelName();
        List<Car> list = modelCars.getOrDefault(modelName, new ArrayList<>());
        list.add(car);
        modelCars.putIfAbsent(modelName, list);
    }

    @Override
    public CarsReturnCode addDriver(Driver driver) {
        lockUnlock_addDriver(true);
        try {
            return drivers.putIfAbsent(driver.getLicenceId(), driver) == null ? CarsReturnCode.OK : CarsReturnCode.DRIVER_EXISTS;
        } finally {
            lockUnlock_addDriver(false);
        }
    }

    @Override
    public CarsReturnCode addModel(Model model) {
        lockUnlock_addModel(true);
        try {
            return models.putIfAbsent(model.getModelName(), model) == null ? CarsReturnCode.OK : CarsReturnCode.MODEL_EXISTS;
        } finally {
            lockUnlock_addModel(false);
        }
    }

    @Override
    public Car getCar(String regNumber) {
        lockUnlock_getCar(true);
        try {
            return cars.get(regNumber);
        } finally {
            lockUnlock_getCar(false);
        }
    }

    @Override
    public Model getModel(String modelName) {
        lockUnlock_getModel(true);
        try {
            return models.get(modelName);
        } finally {
            lockUnlock_getModel(false);
        }
    }

    @Override
    public Driver getDriver(long licenceId) {
        lockUnlock_getDriver(true);
        try {
            return drivers.get(licenceId);
        } finally {
            lockUnlock_getDriver(false);
        }
    }

    @Override
    public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
        lockUnlock_rentCar(true);
        try {
            Car car = getCar(regNumber);
            if (car == null) {
                return CarsReturnCode.NO_CAR;
            }
            if (car.isFlRemoved()) {
                return CarsReturnCode.CAR_REMOVED;
            }
            if (car.isInUse()) {
                return CarsReturnCode.CAR_IN_USE;
            }
            if (!drivers.containsKey(licenseId)) {
                return CarsReturnCode.NO_DRIVER;
            }
            RentRecord record = new RentRecord(regNumber, licenseId, rentDate, rentDays);
            addtoCarRecords(record);
            addToDriverRecords(record);
            addToRecords(record);
            car.setInUse(true);
            return CarsReturnCode.OK;
        } finally {
            lockUnlock_rentCar(false);
        }
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
        lockUnlock_getCarsByDriver(true);
        try {
            List<RentRecord> list = driverRecords.getOrDefault(licenseId, new ArrayList<>());
            return list.stream()
                    .map(rr -> getCar(rr.getRegNumber()))
                    .distinct()
                    .toList();
        } finally {
            lockUnlock_getCarsByDriver(false);
        }
    }

    @Override
    public List<Driver> getDriversByCar(String regNumber) {
        lockUnlock_getDriversByCar(true);
        try {
            List<RentRecord> list = carRecords.getOrDefault(regNumber, new ArrayList<>());
            return list.stream()
                    .map(rr -> getDriver(rr.getLicenseId()))
                    .distinct()
                    .toList();
        }finally {
            lockUnlock_getDriversByCar(false);
        }
    }

    @Override
    public List<Car> getCarsByModel(String modelName) {
        lockUnlock_getCarsByModel(true);
        try {
            return modelCars.getOrDefault(modelName, new ArrayList<>()).stream().filter(c -> !c.isFlRemoved() && !c.isInUse()).toList();
        } finally {
            lockUnlock_getCarsByModel(false);
        }
    }

    @Override
    public List<RentRecord> getRentRecordsAtDate(LocalDate fromDate, LocalDate toDate) {
        lockUnlock_getRentRecordsAtDate(true);
        try {
            Collection<List<RentRecord>> col = records.subMap(fromDate, toDate).values();
            return col.stream()
                    .flatMap(Collection::stream).toList();
        } finally {
            lockUnlock_getRentRecordsAtDate(false);
        }
    }

//sprint 3
    @Override
    public RemovedCarData removeCar(String regNumber) {
        lockUnlock_removeCar(true);
        try {
            Car car = getCar(regNumber);
            if (car == null) {
                return null;
            }
            car.setFlRemoved(true);
            return car.isInUse() ? new RemovedCarData(car, null) : actualCarRemove(car);
        } finally {
            lockUnlock_removeCar(false);
        }
    }

    private RemovedCarData actualCarRemove(Car car) {
        String regNumber = car.getRegNumber();
        List<RentRecord> list = carRecords.get(regNumber);
        if (list != null) {

            cars.remove(regNumber);
            carRecords.remove(regNumber);
            removeFromDriverRecords(list);
            removeFromRecords(list);
            removeFromModelCars(car);
        }
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
        lockUnlock_removeCar(true);
        try {
            List<Car> list = modelCars.get(modelName);
            if (list != null && !list.isEmpty()) {
                return list.stream()
                        .map(c -> removeCar(c.getRegNumber()))
                        .toList();
            }
            return new ArrayList<>();
        } finally {
            lockUnlock_removeCar(false);
        }
    }

    @Override
    public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent) {
        lockUnlock_returnCar(true);
        try {
            RentRecord record = driverRecords.get(licenseId)
                    .stream()
                    .filter(rr -> rr.getRegNumber().equals(regNumber) && rr.getReturnDate() == null)
                    .findFirst()
                    .orElse(null);
            if (record == null) {
                return null;
            }
            updateRecord(record, returnDate, damages, tankPercent);
            Car car = getCar(regNumber);
            updateCar(car, damages);
            return car.isFlRemoved() || damages > REMOVE_THRESHOLD ? actualCarRemove(car) : new RemovedCarData(car, null);
        }finally {
            lockUnlock_returnCar(false);
        }

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
        lockUnlock_getMostPopularCarModels(true);
        try {
            List<RentRecord> list = getRentRecordsAtDate(dataFrom, dataTo);
            Map<String, Long> map = list.stream().filter(rr -> isProperAge(rr, ageFrom, ageTo))
                    .collect(Collectors.groupingBy(rr -> getCar(rr.getRegNumber()).getModelName(), Collectors.counting()));
            long max = Collections.max(map.values());
            List<String> models = new ArrayList<>();
            map.forEach((k, v) -> {
                if (v == max) {
                    models.add(k);
                }
            });
            return models;
        } finally {
            lockUnlock_getMostPopularCarModels(false);
        }
    }
    public boolean isProperAge(RentRecord rr, int ageFrom, int ageTo){
        LocalDate rentDate = rr.getRentDate();
        int birthYear= getDriver(rr.getLicenseId()).getBirthYear();
        int age = rentDate.getYear() - birthYear;
        return age > ageFrom && age <= ageTo;
    }


    @Override
    public List<String> getMostProfitableCarModels(LocalDate dataFrom, LocalDate dataTo) {
        lockUnlock_getMostProfitableCarModels(true);
        try {
            List<RentRecord> list = getRentRecordsAtDate(dataFrom, dataTo);
            if (list.isEmpty()) {
                return new ArrayList<>();
            }
            Map<String, Double> map = list.stream()
                    .collect(Collectors.groupingBy(rr -> getCar(rr.getRegNumber()).getModelName(),
                            Collectors.summingDouble(RentRecord::getCost)));
            double max = map.values().stream().mapToDouble(c -> c).max().getAsDouble();
            List<String> models = new ArrayList<>();
            map.forEach((k, v) -> {
                if (v == max) {
                    models.add(k);
                }
            });
            return models;
        } finally {
            lockUnlock_getMostProfitableCarModels(false);
        }
    }

    @Override
    public List<Driver> getMostActiveDrivers() {
        lockUnlock_getMostActiveDrivers(true);
        try {
            long max = driverRecords.values()
                    .stream().mapToLong(List::size)
                    .max().getAsLong();
            List<Driver> res = new ArrayList<>();
            driverRecords.forEach((k, v) -> {
                if (v.size() == max) {
                    res.add(getDriver(k));
                }
            });
            return res;
        } finally {
            lockUnlock_getMostActiveDrivers(false);
        }
    }

    //sprint 5
    @Override
    public List<String> getModelNames() {
        lockUnlock_getModelNames(true);
        try {
            return new ArrayList<>(models.keySet());
        } finally {
            lockUnlock_getModelNames(false);
        }
    }


}
