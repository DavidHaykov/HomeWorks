package telran.cars.model;

import telran.cars.dto.*;
import telran.cars.utils.Persistable;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.spi.LocaleServiceProvider;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable {
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
}
