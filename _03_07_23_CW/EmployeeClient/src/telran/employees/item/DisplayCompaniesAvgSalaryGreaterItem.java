package telran.employees.item;

import telran.employees.service.EmployeesTcpProxy;
import view.InputOutput;

import java.io.IOException;

public class DisplayCompaniesAvgSalaryGreaterItem extends EmployeesItem{
    public DisplayCompaniesAvgSalaryGreaterItem(EmployeesTcpProxy employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Display companies with greater average salary";
    }

    @Override
    public void perform() throws IOException {
        inOut.outputLine(employees.getCompaniesGreaterAvgSalary());
    }
}
