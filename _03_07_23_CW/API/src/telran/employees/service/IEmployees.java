package telran.employees.service;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

import java.io.Serializable;
import java.util.List;

public interface IEmployees {
    boolean hireEmployee(Employee employee);
    boolean fireEmployee(int id);
    Employee getEmployeeData(int id);

    List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo);
    List<CompanySalary> getCompaniesAvgSalary();
    List<CompanySalary> getCompaniesGreaterAvgSalary();
    int getAvgSalary();


}
