package telran.cars.model;

import telran.cars.dto.*;

import java.io.Serializable;

public interface IRentCompany extends Serializable {
    int getGasPrice();
    void setGasPrice(int price);
    int getFinePercent();
    void setFinePercent(int finePercent);

    CarsReturnCode addCar(Car car);
    CarsReturnCode addDriver(Driver driver);
    CarsReturnCode addModel(Model model);

    Car getCar(String regNumber);
    Model getModel(String modelName);
    Driver getDriver (long licenceId);

}
