package org.example;

public class Person {
    ;
    int id;
    String name;
    Gender gender;

    Person(int id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
    public enum Gender{
        MALE, FEMALE
    }
}
