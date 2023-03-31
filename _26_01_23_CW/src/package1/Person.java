package package1;

import java.util.Arrays;

public class Person {
    String name;
    String surName;

    public Person(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public void display(){
        System.out.println(name);
    }
    public void display(String str){
        System.out.println(name);
    }

}
