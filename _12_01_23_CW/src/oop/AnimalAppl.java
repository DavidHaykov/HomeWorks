package oop;

public class AnimalAppl {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = new Animal(
                "Bogdana",
                16
        );
        System.out.println(animal1);
        System.out.println(animal1.getAge());
        System.out.println(animal1.getName());
        animal1.setAge(18);
        System.out.println(animal1.getAge());

        Animal an = new Animal("Name", 1000);
        System.out.println(an);
    }
}
