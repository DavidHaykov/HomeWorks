package org.example;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Employee extends Person implements Serializable {
    String company;
    int salary;
    String title;

    public Employee(int id, String name, Adress adress, LocalDate birthDate, String company, int salary, String title) {
        super(id, name, adress, birthDate);
        this.company = company;
        this.salary = salary;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "company='" + company + '\'' +
                ", salary=" + salary +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", adress=" + adress +
                ", birthDate=" + birthDate +
                '}';
    }
}
