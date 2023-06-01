package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class PersonWriteAppl {
    public static void main(String[] args) {
        Person p  = new Person(1, "Vasya", new Adress("Haifa", "Hanita", 10), LocalDate.now());
        Child c = new Child(2, "Petya", new Adress("Haifa", "Hanita", 10), LocalDate.now(), "Solnyshko");
        Employee e =
                new Employee(3, "Masha",
                        new Adress("Haifa", "Hanita", 10), LocalDate.of(1980,10,10),
                        "IBM", 10000, "QA");

        ArrayList<Person> list = new ArrayList<>(Arrays.asList(p,c,e));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("persons.data"))){
            out.writeObject(list);
        } catch (IOException e1){
            e1.printStackTrace();
        }
    }

}
