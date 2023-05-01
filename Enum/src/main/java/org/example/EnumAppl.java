package org.example;

import java.util.Arrays;

public class EnumAppl {
    public static void main(String[] args) {
        Weekday first = Weekday.FRI;
        Person person = new Person(11111, "Dudu", Person.Gender.MALE);

        Weekday[] array = Weekday.values();
        System.out.println(Arrays.toString(array));

    }

}