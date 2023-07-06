package telran.employeesServer.servise;

import com.sun.jdi.connect.ListeningConnector;
import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeesMaps implements IEmployees {
    private HashMap<Integer, Employee> employees;
    private HashMap<String, List<Employee>> companies;
    private TreeMap<Integer, List<Employee>> salaries;

    public EmployeesMaps() {
        this.employees = new HashMap<>();
        this.companies = new HashMap<>();
        this.salaries = new TreeMap<>();
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        if(employees.containsValue(employee)){
            System.out.println("Employee is exist");
            return false;
        }
        addEmployee(employee);

        return true;
    }

    private void addEmployee(Employee employee) {
        employees.putIfAbsent(employee.getId(), employee);
        List<Employee> cur = companies.getOrDefault(employee.getCompanyName(), new ArrayList<>());
        cur.add(employee);
        companies.putIfAbsent(employee.getCompanyName(), cur);
        cur = salaries.getOrDefault(employee.getSalary(), new ArrayList<>());
        cur.add(employee);
        salaries.putIfAbsent(employee.getSalary(), cur);
    }

    @Override
    public boolean fireEmployee(int id) {
        Employee employee = getEmployeeData(id);
        if(!employees.containsKey(employee.getId())){
            return false;
        }
        employees.remove(employee.getId());
        List<Employee> cur = companies.getOrDefault(employee.getCompanyName(), new ArrayList<>());
        cur.removeIf(e -> e.getId() == employee.getId());
        if(cur.isEmpty()){
            companies.remove(employee.getCompanyName());
        }else {
            cur.removeIf(e -> e.getId() == employee.getId());
            companies.put(employee.getCompanyName(), cur);
        }
        cur = salaries.getOrDefault(employee.getSalary(), new ArrayList<>());
        if(cur.isEmpty()){
            salaries.remove(employee.getSalary());
        }else {
            cur.removeIf(e -> e.getId() == employee.getId());
            salaries.put(employee.getSalary(), cur);
        }
        return true;
    }

    @Override
    public Employee getEmployeeData(int id) {
        return employees.get(id);
    }

    @Override
    public List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo) {
        return employees.values().stream().filter(e -> e.getSalary() >= salaryFrom && e.getSalary() < salaryTo).toList();
    }

    @Override
    public List<CompanySalary> getCompaniesAvgSalary() {
           return companies.entrySet().stream()
                   .map(entry -> new CompanySalary(entry.getKey(), entry.getValue().stream()
                           .mapToInt(Employee::getSalary).average().orElse(0)))
                   .collect(Collectors.toList());
    }

    @Override
    public List<CompanySalary> getCompaniesGreaterAvgSalary() {
        double max = getCompaniesAvgSalary().stream()
                .mapToDouble(CompanySalary::getAvgSalary)
                .max().getAsDouble();

        return getCompaniesAvgSalary().stream().filter(cs -> cs.getAvgSalary() == max)
                .collect(Collectors.toList());
    }

    @Override
    public int getAvgSalary() {
        double avg = salaries.keySet().stream().mapToInt(Integer::intValue)
                .average().orElse(0);
        return (int)avg;
    }
}
