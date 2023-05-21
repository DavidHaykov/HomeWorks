package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee employee= new Employee(34519101, "Garik", "YoptaPhone", 40000);
        Employee employee1= new Employee(34519345, "John", "Bastards LTD", 62000);
        Employee employee2= new Employee(34245221, "Ivan", "Ars motors", 10000);
        Employee employee3= new Employee(34546661, "Dudu", "GA-GA cofeeshop", 10000);
        Employee employee4= new Employee(39923515, "Jora", "YoptaPhone", 50000);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        displayAverageMnMaxSalary(employees);
        displayAverageSalary(employees, "YoptaPhone");
        displayEmployeesAvgSalary(employees);
        displayBiggestCompanies(employees);
        displayCompaniesAboveAvgSalary(employees);
        displayEmployeesBySalaryIntervals(employees, 2000);

    }

    public static void displayAverageMnMaxSalary(List<Employee> employees){
        IntSummaryStatistics res = employees.stream()
                .mapToInt(e -> e.getSalary())
                .summaryStatistics();
        System.out.printf("average = %.0f, min = %d, max = %d\n", res.getAverage(),res.getMin(),res.getMax());
    }

    public static void displayAverageSalary(List<Employee> employees,String company){
        System.out.println(employees.stream()
                .filter(e -> e.getCompany().equals(company))
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0));

    }

    public static void displayEmployeesAvgSalary(List<Employee> employees){
        double avgSalary = employees.stream()
                .mapToInt(e -> e.getSalary())
                .summaryStatistics().getAverage();
        employees.stream().filter(e -> e.getSalary() > avgSalary)
                .forEach(e -> System.out.print("Name: " + e.getName() + ", Salary: " + e.getSalary()+ "\n"));

        /*public static void displayEmployeesAvgSalary (List‹Employee› employees)
        {
            double avgSalary = employees.stream() .mapToInt (e -› e.salary) . average () . getAsDouble();
            employees.stream().filter (e -› e.salary › avgSalary)
            Imap (e -> new NameSalary (e.name, e.salary)) .forEach(System.out: :print]n);
            forEach(e -› System.out.println(e.name + " + e.salary));
        }
        */      // CREATING


    }

    // HW 18/05

    public static void displayBiggestCompanies (List<Employee> employees){
        Map<Object, List<Employee>> employeeCount = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getCompany()));
        employeeCount.entrySet()
                .stream().sorted(new Comparator<Map.Entry<Object, List<Employee>>>() {
                    @Override
                    public int compare(Map.Entry<Object, List<Employee>> o1, Map.Entry<Object, List<Employee>> o2) {
                        return Integer.compare(o2.getValue().size(), o1.getValue().size());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(1)
                .forEach(System.out::println);

    }

    public static void displayCompaniesAboveAvgSalary (List<Employee> employees){
        double avgSalary = employees.stream()
                .mapToInt(e -> e.getSalary())
                .average().orElse(0);
        Map<Boolean, List<Employee>> companiesWithBiggestSalary = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() >= avgSalary));
        companiesWithBiggestSalary.entrySet().stream()
                .filter(Map.Entry::getKey)
                .flatMap(e -> e.getValue().stream())
                .map(Employee::getCompany)
                .distinct()
                .forEach(System.out::println);

    }

    static void displayEmployeesBySalaryIntervals(List<Employee> employees, int interval) {
        Map<String, List<Employee>> intervalMap = employees.stream()
                .collect(Collectors.groupingBy( employee -> {
                    int start = (employee.getSalary()/interval) * interval;
                    int finish = start + interval;
                    return "[" + start + "-" + finish +"]";
                }, TreeMap::new, Collectors.toList()));
        intervalMap.entrySet().stream().forEach(System.out::println);
    }

}