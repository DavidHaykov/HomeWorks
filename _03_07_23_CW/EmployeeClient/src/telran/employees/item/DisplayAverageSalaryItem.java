package telran.employees.item;

import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import view.InputOutput;

import java.io.IOException;

public class DisplayAverageSalaryItem extends EmployeesItem{

    public DisplayAverageSalaryItem(IEmployees employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Display average salary";
    }

    @Override
    public void perform() throws IOException {
        inOut.outputLine(employees.getAvgSalary());
    }
}
