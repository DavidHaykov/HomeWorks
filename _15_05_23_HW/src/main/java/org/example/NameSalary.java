package org.example;

public class NameSalary {
    private String name;
    private int salary;

    public NameSalary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "NameSalary{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
