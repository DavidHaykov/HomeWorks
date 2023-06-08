package telran.cars.model;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.utils.Persistable;

import java.util.HashMap;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable {

    HashMap<String, Car> cars = new HashMap<>();
    HashMap<String, Driver> drivers = new HashMap<>();
    HashMap<String, Model> models = new HashMap<>();


    @Override
    public CarsReturnCode addCar(Car car) {

        return null;
    }

    @Override
    public CarsReturnCode addDriver(Driver driver) {
        return drivers.putIfAbsent(driver.getName(), driver) == null ? CarsReturnCode.OK : CarsReturnCode.DRIVER_EXISTS;
    }

    @Override
    public CarsReturnCode addModel(Model model) {
        return models.putIfAbsent(model.getModelName(), model) ==  null  ? CarsReturnCode.OK : CarsReturnCode.MODEL_EXISTS;
    }

    @Override
    public Car getCar(String regNumber) {
        return null;
    }

    @Override
    public Model getModel(String modelName) {
        return models.get(modelName);
    }

    @Override
    public Driver getDriver(long licenceId) {
        return null;
    }

    @Override
    public void save(String fileName) {

    }
}
