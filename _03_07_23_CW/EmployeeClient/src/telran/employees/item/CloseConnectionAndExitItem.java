package telran.employees.item;

import telran.employees.dto.Employee;
import telran.employees.service.EmployeesTcpProxy;
import view.InputOutput;

import java.io.IOException;

public class CloseConnectionAndExitItem extends EmployeesItem {
    public CloseConnectionAndExitItem(EmployeesTcpProxy employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Close connection and exit Item";
    }

    @Override
    public void perform() throws IOException {
        employees.close();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
