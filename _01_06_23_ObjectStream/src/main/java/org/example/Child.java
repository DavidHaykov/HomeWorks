package org.example;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Child extends Person implements Serializable {
    String garden;

    public Child(int id, String name, Adress adress, LocalDate birthDate, String garden) {
        super(id, name, adress, birthDate);
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "Child{" +
                "garden='" + garden + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", adress=" + adress +
                ", birthDate=" + birthDate +
                '}';
    }
}
