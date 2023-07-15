package telran.employees.item;

import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import view.InputOutput;
import view.Item;

public abstract class EmployeesItem implements Item {
protected IEmployees employees;
protected InputOutput inOut;
    public EmployeesItem(IEmployees employees, InputOutput inOut)  {
        this.employees = employees;
        this.inOut = inOut;
    }
    public Integer getIdIfNotExist() {
        Integer id = inOut.inputInteger("Enter employee ID");
        if(id == null){
            return null;
        }
        if(employees.getEmployeeData(id) != null){
            inOut.outputLine("Employee already exist");
            return null;
        }
        return id;
    }
    public Integer getIdIfExist() {
        Integer id = inOut.inputInteger("Enter employee ID");
        if(id == null){
            return null;
        }
        if(employees.getEmployeeData(id) == null){
            inOut.outputLine("Employee is not exist");
            return null;
        }
        return id;
    }
}
