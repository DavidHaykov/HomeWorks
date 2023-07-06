package telran.employees.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Employee implements Serializable {
    private int id;
    private String name;
    private String companyName;
    private int salary;

    public Employee() {
    }

    public Employee(int id, String name, String companyName, int salary) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, companyName, salary);
    }
}
