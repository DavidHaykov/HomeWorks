package telran.employees.item;

import telran.employees.dto.Employee;
import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import view.InputOutput;
import view.Item;

import java.io.IOException;

public class CloseConnectionAndExitItem extends EmployeesItem {
    public CloseConnectionAndExitItem(IEmployees employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Close connection and exit Item";
    }

    @Override
    public void perform() throws IOException {
        ((EmployeesTcpProxy)employees).close();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
