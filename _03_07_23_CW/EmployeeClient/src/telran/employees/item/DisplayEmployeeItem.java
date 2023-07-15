package telran.employees.item;

import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import view.InputOutput;

import java.io.IOException;

public class DisplayEmployeeItem extends EmployeesItem{
    public DisplayEmployeeItem(IEmployees employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Display employee data";
    }

    @Override
    public void perform() throws IOException {
        Integer id = getIdIfExist();
        if(id == null){
            return;
        }
        inOut.output(employees.getEmployeeData(id));
    }
}
