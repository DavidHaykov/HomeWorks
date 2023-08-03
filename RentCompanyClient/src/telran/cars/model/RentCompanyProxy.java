package telran.cars.model;

import telran.net.TcpClientJava;
import teltan.cars.api.ApiConstants;
import teltan.cars.dto.*;
import teltan.cars.model.IRentCompany;

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
    public void setFinePercent(int finePercent) {

    }

    @Override
    public CarsReturnCode addCar(Car car) {
        return sendRequest(ApiConstants.ADD_CAR, car);
    }

    @Override
    public CarsReturnCode addDriver(Driver driver) {
        return null;
    }

    @Override
    public CarsReturnCode addModel(Model model) {
        return null;
    }

    @Override
    public Car getCar(String regNumber) {
        return sendRequest(ApiConstants.GET_CAR, regNumber);
    }

    @Override
    public Model getModel(String modelName) {
        return null;
    }

    @Override
    public Driver getDriver(long licenceId) {
        return null;
    }

    @Override
    public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
        return sendRequest(ApiConstants.RENT_CAR, new RentCarData(regNumber, licenseId, rentDate, rentDays));
    }

    @Override
    public List<Car> getCarsByDriver(long licenseId) {
        return null;
    }

    @Override
    public List<Driver> getDriversByCar(String regNumber) {
        return null;
    }

    @Override
    public List<Car> getCarsByModel(String modelName) {
        return null;
    }

    @Override
    public List<RentRecord> getRentRecordsAtDate(LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public RemovedCarData removeCar(String regNumber) {
        return null;
    }

    @Override
    public List<RemovedCarData> removeCarsOfModel(String modelName) {
        return null;
    }

    @Override
    public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent) {
        return null;
    }

    @Override
    public List<String> getMostPopularCarModels(LocalDate dataFrom, LocalDate dataTo, int ageFrom, int ageTo) {
        return sendRequest(ApiConstants.GET_MOST_POPULAR_MODELS, new StatisticsData(dataFrom, dataTo, 0 ,0));
    }

    @Override
    public List<String> getMostProfitableCarModels(LocalDate dataFrom, LocalDate dataTo) {
        return null;
    }

    @Override
    public List<Driver> getMostActiveDrivers() {
        return null;
    }

    @Override
    public List<String> getModelNames() {
        return null;
    }
}
