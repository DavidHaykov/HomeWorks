package telran.employees.item;

import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import view.InputOutput;

import java.io.IOException;

public class DisplayEmployeesSalaryItem extends EmployeesItem{

    public DisplayEmployeesSalaryItem(IEmployees employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Display employees by salary";
    }

    @Override
    public void perform() throws IOException {
        Integer salaryFrom = inOut.inputInteger("Enter MIN salary", 0, Integer.MAX_VALUE);
        if(salaryFrom == null){
            return;
        }
        Integer salaryTo = inOut.inputInteger("Enter MAX salary", salaryFrom, Integer.MAX_VALUE);
        if(salaryTo == null){
            return;
        }
        if(salaryTo < salaryFrom){
            System.out.println("salary TO < salary FROM");
            return;
        }
        inOut.outputLine(employees.getEmployeesDataBySalary(salaryFrom, salaryTo));
    }
}
