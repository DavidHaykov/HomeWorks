package package1;

import package1.Animal;

import java.util.Arrays;

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

        animal1.setAge(10);
        System.out.println(animal1);
        Fish fish = new Fish("nemo", 2,true);
        Animal dog = new Dog("Dog", 1, "boxer");
        Animal cat = new Cat("Cat", 10, "black");
        Fish fish1 = new Fish("FISH",1,false);
        Fish fish2 = new Fish("FISH",1,false);


        String[] animals = {
                String.valueOf(fish),
                String.valueOf(dog),
                String.valueOf(cat)
        };
        printAnimals(animals);
        dog.voice();

        Animal[] array = {
                dog,
                cat,
                (Animal) fish
        };

        for(int i = 0; i< array.length; i++) {
            if (array[i] instanceof Fish) {
                ((Fish) array[i]).fishVoice();
            } else if (array[i] instanceof Cat) {
                ((Cat) array[i]).catVoice();
            } else if (array[i] instanceof Dog) {
                ((Dog) array[i]).dogVoice();
            } else if (array[i] instanceof Animal) {
                ((Animal) array[i]).animalVoice();
            } else {
                System.out.println("Kto ti tvar?!");
            }

        }
        System.out.println( fish == fish1);
        System.out.println(fish1==fish2);
        System.out.println(fish.equals(fish1));
        System.out.println(fish1.equals(fish2));
    }

    public static void printAnimals (String[] animals){
        for(String animal : animals){
            System.out.println(animal);
            System.out.println("\n");
        }
    }
}
