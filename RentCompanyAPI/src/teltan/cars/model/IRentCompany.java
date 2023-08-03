package teltan.cars.model;


import teltan.cars.dto.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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

    //sprint 2
    CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays);
    List<Car> getCarsByDriver(long licenseId);
    List<Driver> getDriversByCar(String regNumber);
    List<Car> getCarsByModel(String modelName);
    List<RentRecord> getRentRecordsAtDate(LocalDate fromDate, LocalDate toDate);

    //sprint 3
    RemovedCarData removeCar(String regNumber);
    List<RemovedCarData> removeCarsOfModel(String modelName);
    RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent);

    //sprint 4
    List<String> getMostPopularCarModels(LocalDate dataFrom, LocalDate dataTo, int ageFrom, int ageTo);
    List<String> getMostProfitableCarModels(LocalDate dataFrom, LocalDate dataTo);
    List<Driver> getMostActiveDrivers();

    // sprint 5
    List<String> getModelNames();

}
