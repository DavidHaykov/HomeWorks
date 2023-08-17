package telran.cars.model;

import telran.cars.dto.*;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TcpResponseCode;
import telran.net.server.ProtocolJava;
import static telran.cars.api.ApiConstants.*;

import java.io.Serializable;
import java.util.List;

public class RentCompanyProtocol implements ProtocolJava {
    IRentCompany service;

    public RentCompanyProtocol(IRentCompany service) {
        this.service = service;
    }

    @Override
    public ResponseJava getResponse(RequestJava request) {
        String type = request.requestType;
        Serializable data = request.requestData;
        switch (type){
            case ADD_CAR: return _car_add(data);
            case ADD_MODEL: return _model_add(data);
            case RENT_CAR: return _car_rent(data);
            case GET_DRIVER_CARS: return _driver_cars(data);
            case GET_CAR_MODELS: return _models(data);
            case GET_MODEL_CARS: return  _model_cars(data);
            case RETURN_CAR: return _car_return(data);
            case GET_CAR_DRIVERS: return _drivers_car(data);
            case GET_CAR: return _car(data);
            case GET_DRIVER: return _driver(data);
            case REMOVE_CAR: return _car_remove(data);
            case REMOVE_MODEL: return _model_remove(data);
            case GET_MOST_ACTIVE_DRIVERS: return _drivers_active(data);
            case GET_MOST_POPULAR_MODELS: return _models_popular(data);
            case GET_MOST_PROFITABLE_MODELS:return _models_profitable(data);
            case GET_RECORDS: return _records(data);
        }
        return null;
    }

    private ResponseJava _records(Serializable data) {
        try{
            StatisticsData sd = (StatisticsData) data;
            List<RentRecord> res = service.getRentRecordsAtDate(sd.getFromDate(), sd.getToDate());
            return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
        }catch (Exception e){
            return wrongResponse();
        }

    }

    private ResponseJava _models_profitable(Serializable data) {
        try{
            StatisticsData sd = (StatisticsData) data;
            List<String> res = service.getMostProfitableCarModels(sd.getFromDate(), sd.getToDate());
            return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
        }catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _models_popular(Serializable data) {
        try {
            StatisticsData sd = (StatisticsData) data;
            List<String> res = service.getMostPopularCarModels(sd.getFromDate(), sd.getToDate(), sd.getFromAge(), sd.getToAge());
            return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
        } catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _drivers_active(Serializable data) {
        try {
            List<Driver> res = service.getMostActiveDrivers();
            return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
        }catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _model_remove(Serializable data) {
        try{
            String modelName = (String) data;
            List<RemovedCarData> res = service.removeCarsOfModel(modelName);
            return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
        }catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _car_remove(Serializable data) {
        try {
            String regNumber = (String) data;
            RemovedCarData res = service.removeCar(regNumber);
            return new ResponseJava(TcpResponseCode.OK, res);
        }catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _driver(Serializable data) {
        try {
            long licenseId = (long) data;
            Driver driver = service.getDriver(licenseId);
            return new ResponseJava(TcpResponseCode.OK, driver);
        }catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _car(Serializable data) {
        try {
            String regNumber = (String) data;
            Car car = service.getCar(regNumber);
            return new ResponseJava(TcpResponseCode.OK, car);
        }catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _drivers_car(Serializable data) {
        try{
            String regNumber = (String) data;
            List<Driver> res = service.getDriversByCar(regNumber);
            return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
        } catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _car_return(Serializable data) {
        try {
            ReturnCarData rcd = (ReturnCarData) data;
            RemovedCarData res = service.returnCar(rcd.getRegNumber(), rcd.getLicenceId(), rcd.getReturnDate(), rcd.getDamages(), rcd.getTankPercent());
            return new ResponseJava(TcpResponseCode.OK, res);
        } catch (Exception e ){
            return wrongResponse();
        }
    }

    private ResponseJava _model_cars(Serializable data) {
        try {
            String modelName = (String) data;
            List<Car> res = service.getCarsByModel(modelName);
            return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
        }catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _models(Serializable data) {
        try {
            List<String> models = service.getModelNames();
            return new ResponseJava(TcpResponseCode.OK, (Serializable) models);
        } catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _driver_cars(Serializable data) {
        try {
            long licenseId = (long) data;
            List<Car> res = service.getCarsByDriver(licenseId);
            return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
        }catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _car_rent(Serializable data) {
        try {
             RentCarData rcd = (RentCarData) data;
             CarsReturnCode res = service.rentCar(rcd.getRegNumber(), rcd.getLicenceId(), rcd.getRentDate(), rcd.getRentDays());
            return new ResponseJava(TcpResponseCode.OK, res);
        } catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _model_add(Serializable data) {
        try {
            Model model = (Model) data;
            CarsReturnCode res = service.addModel(model);
            return new ResponseJava(TcpResponseCode.OK, res);
        } catch (Exception e){
            return wrongResponse();
        }
    }

    private ResponseJava _car_add(Serializable data) {
        try {
            Car car = (Car) data;
            CarsReturnCode res = service.addCar(car);
            return new ResponseJava(TcpResponseCode.OK, res);
        } catch (Exception e){
            return wrongResponse();
        }
    }
    private ResponseJava wrongResponse(){
        return new ResponseJava(TcpResponseCode.WRONG_REQUEST, null);
    }
}
