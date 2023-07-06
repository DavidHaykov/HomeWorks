package telran.employees.service;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.net.TcpClientJava;

import java.util.List;

public class EmployeesTcpProxy extends TcpClientJava implements IEmployees {

    public EmployeesTcpProxy(String hostname, int port) throws Exception {
        super(hostname, port);
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        return sendRequest("hireEmployee", employee);
    }

    @Override
    public boolean fireEmployee(int id) {
        return sendRequest("fireEmployee", id);
    }

    @Override
    public Employee getEmployeeData(int id) {
        return sendRequest("getEmployeeData", id);
    }

    @Override
    public List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo) {
        int[] data = {salaryFrom, salaryTo};
        return sendRequest("getEmployeesDataBySalary", data);
    }

    @Override
    public List<CompanySalary> getCompaniesAvgSalary() {
        return sendRequest("getCompaniesAvgSalary", null);
    }

    @Override
    public List<CompanySalary> getCompaniesGreaterAvgSalary() {
        return sendRequest("getCompaniesGreaterAvgSalary", null);
    }

    @Override
    public int getAvgSalary() {
        return sendRequest("getAvgSalary", null);
    }
}
