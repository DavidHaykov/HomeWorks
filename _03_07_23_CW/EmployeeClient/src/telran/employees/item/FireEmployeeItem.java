package telran.employees.item;

import telran.employees.dto.Employee;
import telran.employees.service.EmployeesTcpProxy;
import view.InputOutput;

import java.io.IOException;

public class FireEmployeeItem extends EmployeesItem{
    public FireEmployeeItem(EmployeesTcpProxy employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Fire employee";
    }

    @Override
    public void perform() throws IOException {

        Integer id = getIdIfExist();
        if(id == null){
            return;
        }
        inOut.output(employees.fireEmployee(id));
    }
}
