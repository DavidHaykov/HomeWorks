package org.example.animal;

public class Parrot extends Pet implements IRunable, IFlyable,IBoxable{
    public boolean talk;

    public Parrot(String name, int age, char gender, boolean talk) {
        super(name, age, gender);
        this.talk = talk;
    }
    public void voice(){
        if(talk) {
            System.out.println("BASTARD!!!");
        }else{
            System.out.println("prosto orut");
        }
    }

    @Override
    public void fly() {

    }

    @Override
    public void run() {

    }
}
