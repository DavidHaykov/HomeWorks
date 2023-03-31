package package1;

import java.util.Objects;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        if(name!=null&&!name.isEmpty()) {
            this.name = name;
        }else {
            System.out.println("No name");
        }
        if(age>0&&age<=120) {
            this.age = age;
        }else {
            System.out.println("No age");
        }
    }
    public Animal() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name!=null&&!name.isEmpty()) {
            this.name = name;
        }else {
            System.out.println("No name");
        }
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age>0&&age<=120) {
            this.age = age;
        }else {
            System.out.println("No age");
        }
    }

    public void voice(){

        System.out.println("Voice of animal");
    }
    public void animalVoice(){

        System.out.println("Voice of animal");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}