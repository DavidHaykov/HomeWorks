package org.example;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Adress implements Serializable {
    String city;
    String street;
    int building;

    public Adress(String city, String street, int building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                '}';
    }
}
