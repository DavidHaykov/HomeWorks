package telran.employees.item;

import telran.employees.dto.Employee;
import telran.employees.service.EmployeesTcpProxy;
import view.InputOutput;

import java.io.IOException;

public class HireEmployeeItem extends EmployeesItem{
    public HireEmployeeItem(EmployeesTcpProxy employees, InputOutput inOut) {
        super(employees, inOut);
    }

    @Override
    public String displayedName() {
        return "Hire employee";
    }

    @Override
    public void perform() throws IOException {
        Integer id = getIdIfNotExist();
        if(id == null){
            return;
        }
        String name = inOut.inputString("Enter employee name");
        if( name == null){
            return;
        }
        String companyName = inOut.inputString("Enter company name");
        if(companyName == null){
            return;
        }
        Integer salary = inOut.inputInteger("Enter employee salary", 0, 1000000);
        if(salary == null){
            return;
        }
        Employee employee = new Employee(id, name, companyName, salary);
        inOut.output(employees.hireEmployee(employee));
    }


}
