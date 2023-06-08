package telran.cars.model;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.utils.Persistable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Locale;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable {

    HashMap<String, Car> cars = new HashMap<>();
    HashMap<Long, Driver> drivers = new HashMap<>();
    HashMap<String, Model> models = new HashMap<>();


    @Override
    public CarsReturnCode addCar(Car car) {
        if(!models.containsKey(car.getModelName())){
            return CarsReturnCode.NO_MODEL;
        }
        return cars.put(car.getRegNumber(), car) == null ? CarsReturnCode.OK : CarsReturnCode.CAR_EXISTS;
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
    public void save(String fileName) throws IOException {
        try( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(this);
        } catch (Exception e){
            System.out.println("Error in save method " + e.getMessage());
        }
    }
}
