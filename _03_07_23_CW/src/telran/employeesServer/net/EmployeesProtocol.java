package telran.employeesServer.net;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.employeesServer.servise.EmployeesMaps;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TcpResponseCode;
import telran.net.server.ProtocolJava;

import java.io.Serializable;
import java.util.List;

import static telran.net.TcpResponseCode.OK;

public class EmployeesProtocol implements ProtocolJava {
    IEmployees service = new EmployeesMaps();

    public EmployeesProtocol(IEmployees service) {
        this.service = service;
    }

    @Override
    public ResponseJava getResponse(RequestJava request) {
        switch (request.requestType){
            case "hireEmployee":
                Employee m = (Employee) request.requestData;
                return hireEmployee(request.requestData);
                //todo
            case "fireEmployee":
                return fireEmployee(request.requestData);
            case "getEmployeeData":
                return getEmployeeData(request.requestData);
            case "getEmployeesDataBySalary":
                return getEmployeesDataBySalary(request.requestData);
            case "getCompaniesAvgSalary":
                return getCompaniesAvgSalary(request.requestData);
            case "getCompaniesGreaterAvgSalary":
                return getCompaniesGreaterAvgSalary(request.requestData);
            case "getAvgSalary":
                return getAvgSalary(request.requestData);
            default:
                return new ResponseJava(TcpResponseCode.UNKNOWN, null);

        }
    }

    private ResponseJava getAvgSalary(Serializable requestData) {
        try {
            Integer res = service.getAvgSalary();
            return new ResponseJava(OK, res);
        }catch (Exception e){
            return new ResponseJava(TcpResponseCode.WRONG_REQUEST, e.getMessage());
        }
    }

    private ResponseJava getCompaniesGreaterAvgSalary(Serializable requestData) {
        try {
            List<CompanySalary> res = service.getCompaniesGreaterAvgSalary();
            return new ResponseJava(OK, (Serializable) res);
        }catch (Exception e){
            return wrongRequest(e);
        }
    }

    private ResponseJava getCompaniesAvgSalary(Serializable requestData) {
        try {
            List<CompanySalary> res = service.getCompaniesAvgSalary();
            return new ResponseJava(OK, (Serializable) res);
        }catch (Exception e){
            return wrongRequest(e);
        }
    }

    private ResponseJava getEmployeesDataBySalary(Serializable requestData) {
        try {
            Integer[] data = (Integer[]) requestData;
            List<Employee> res = service.getEmployeesDataBySalary(data[0], data[1]);
            return new ResponseJava(OK, (Serializable) res);
        }catch (Exception e){
            return wrongRequest(e);
        }
    }

    private ResponseJava getEmployeeData(Serializable requestData) {
        try {
            Integer employeeId = (Integer) requestData;
            Employee res = service.getEmployeeData(employeeId);
            return new ResponseJava(OK, res);
        }catch (Exception e){
            return wrongRequest(e);
        }
    }

    private ResponseJava wrongRequest(Exception e) {
        return new ResponseJava(TcpResponseCode.WRONG_REQUEST, e.getMessage());
    }

    private ResponseJava fireEmployee(Serializable requestData) {
        try {
            int id = (int) requestData;
            boolean res = service.fireEmployee(id);
            return new ResponseJava(OK, res);
        }catch (Exception e ){
            return wrongRequest(e);

        }

    }

    private ResponseJava hireEmployee(Serializable requestData){
        try {
            Employee emp = (Employee) requestData;
            boolean res = service.hireEmployee(emp);
            return new ResponseJava(OK, res);
        }catch (Exception e ){
           return wrongRequest(e);
        }
    }


}
