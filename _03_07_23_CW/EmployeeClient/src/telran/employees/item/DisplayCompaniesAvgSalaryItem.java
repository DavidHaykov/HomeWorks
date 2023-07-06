package telran.employees.item;

import telran.employees.service.EmployeesTcpProxy;
import view.InputOutput;

import java.io.IOException;

public class DisplayCompaniesAvgSalaryItem extends EmployeesItem{
    public DisplayCompaniesAvgSalaryItem(EmployeesTcpProxy employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Display companies avg salary";
    }

    @Override
    public void perform() throws IOException {
        inOut.output(employees.getCompaniesAvgSalary());
    }
}
