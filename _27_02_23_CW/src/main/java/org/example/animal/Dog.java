package org.example.animal;

public class Dog extends Pet implements IBoxable, IRunable, IFlyable, ISwimable{
    public String breed;

    public Dog(String name, int age, char gender, String breed) {
        super(name, age, gender);
        this.breed = breed;
    }
    public void voice(){
        System.out.println("Gav gav");
    }

    @Override
    public double size(double height, double length, double width) {
        return height*length*width;
    }

    @Override
    public void fly() {

    }

    @Override
    public void run() {

    }

    @Override
    public void swim() {

    }
}
