package scenario3;

import scenario2.G;

public class Cat extends Animal implements  IRunnable{
    public String color;
    protected Gender gender;
    private int id;

    public Cat(String name, String master, int age, String color,  Gender gender, int id) {
        super(name, master, age);
        this.color = color;
        this.gender = gender;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Run");
    }
    public enum Gender{
        M, F
    }

    enum Color{
        GREEN, RED
    }
}
