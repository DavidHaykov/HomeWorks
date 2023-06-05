package org.person;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Person  implements Serializable {

    int id;
    String name;
    Adress adress;
    LocalDate birthDate;

    public Person(int id, String name, Adress adress, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress=" + adress +
                ", birthDate=" + birthDate +
                '}';
    }
}
