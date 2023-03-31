package oop;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        if(name!=null&&!name.isEmpty()) {
            this.name = name;
        }
        if(age>0&&age<=120) {
            this.age = age;
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
        }
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age>0&&age<=120) {
            this.age = age;
        }
    }
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}