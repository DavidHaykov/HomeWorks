package org.example;

import java.util.*;
import java.util.stream.Stream;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee employee= new Employee(34519101, "Garik", "YoptaPhone", 40000);
        Employee employee1= new Employee(34519345, "John", "Bastards LTD", 12000);
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

    }

}