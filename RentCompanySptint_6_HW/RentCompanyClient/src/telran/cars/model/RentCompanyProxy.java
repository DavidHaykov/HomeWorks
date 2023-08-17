package telran.cars.model;

import telran.cars.dto.*;
import telran.net.TcpClientJava;
import telran.cars.api.ApiConstants;

import java.time.LocalDate;
import java.util.List;

public class RentCompanyProxy extends TcpClientJava implements IRentCompany {
    public RentCompanyProxy(String hostname, int port) throws Exception {
        super(hostname, port);
    }

    @Override
    public int getGasPrice() {
        return 0;
    }

    @Override
    public void setGasPrice(int price) {

    }

    @Override
    public int getFinePercent() {
        return 0;
    }

    @Override
    public void setFinePercent(int finePercent) { }

    @Override
    public CarsReturnCode addCar(Car car) {
        return sendRequest(ApiConstants.ADD_CAR, car);
    }

    @Override
    public CarsReturnCode addDriver(Driver driver) {
        return sendRequest(ApiConstants.ADD_DRIVER, driver);
    }

    @Override
    public CarsReturnCode addModel(Model model) {
        return sendRequest(ApiConstants.ADD_MODEL, model);
    }

    @Override
    public Car getCar(String regNumber) {
        return sendRequest(ApiConstants.GET_CAR, regNumber);
    }

    @Override
    public Model getModel(String modelName) {
        return sendRequest(ApiConstants.GET_MODEL, modelName);
    }

    @Override
    public Driver getDriver(long licenceId) {
        return sendRequest(ApiConstants.GET_DRIVER, licenceId);
    }

    @Override
    public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
        return sendRequest(ApiConstants.RENT_CAR, new RentCarData(regNumber, licenseId, rentDate, rentDays));
    }

    @Override
    public List<Car> getCarsByDriver(long licenseId) {
        return sendRequest(ApiConstants.GET_DRIVER_CARS, licenseId);
    }

    @Override
    public List<Driver> getDriversByCar(String regNumber) {
        return sendRequest(ApiConstants.GET_CAR_DRIVERS, regNumber);
    }

    @Override
    public List<Car> getCarsByModel(String modelName) {
        return sendRequest(ApiConstants.GET_MODEL_CARS, modelName);
    }

    @Override
    public List<RentRecord> getRentRecordsAtDate(LocalDate fromDate, LocalDate toDate) {
        return sendRequest(ApiConstants.GET_RECORDS, new StatisticsData(fromDate, toDate, 0 ,0));
    }

    @Override
    public RemovedCarData removeCar(String regNumber) {
        return sendRequest(ApiConstants.REMOVE_CAR, regNumber);
    }

    @Override
    public List<RemovedCarData> removeCarsOfModel(String modelName) {
        return sendRequest(ApiConstants.REMOVE_MODEL, modelName);
    }

    @Override
    public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent) {
        return sendRequest(ApiConstants.RETURN_CAR, new ReturnCarData(regNumber, licenseId, returnDate, damages, tankPercent));
    }

    @Override
    public List<String> getMostPopularCarModels(LocalDate dataFrom, LocalDate dataTo, int ageFrom, int ageTo) {
        return sendRequest(ApiConstants.GET_MOST_POPULAR_MODELS, new StatisticsData(dataFrom, dataTo, ageFrom ,ageTo));
    }

    @Override
    public List<String> getMostProfitableCarModels(LocalDate dataFrom, LocalDate dataTo) {
        return sendRequest(ApiConstants.GET_MOST_PROFITABLE_MODELS, new StatisticsData(dataFrom, dataTo, 0,0));
    }

    @Override
    public List<Driver> getMostActiveDrivers() {
        return sendRequest(ApiConstants.GET_MOST_ACTIVE_DRIVERS, null);
    }

    @Override
    public List<String> getModelNames() {
        return sendRequest(ApiConstants.GET_CAR_MODELS, null);
    }
}
