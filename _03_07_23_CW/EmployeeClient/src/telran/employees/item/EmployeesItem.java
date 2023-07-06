package telran.employees.item;

import telran.employees.service.EmployeesTcpProxy;
import view.InputOutput;
import view.Item;

public abstract class EmployeesItem implements Item {
    protected EmployeesTcpProxy employees;
    protected InputOutput inOut;

    public EmployeesItem(EmployeesTcpProxy employees, InputOutput inOut) {
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
