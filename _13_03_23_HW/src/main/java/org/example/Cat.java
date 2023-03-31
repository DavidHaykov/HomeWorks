package org.example;

public class Cat implements Comparable<Cat>{
   public String name;
   public String breed;
   public int age;
   public double weight;

    public Cat(String name, String breed, int age, double weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        int res = name.compareTo(o.name);
        if(res==0){
            res = Integer.compare(age, o.age);
            if(res==0){
               res = Double.compare(weight, o.weight);
            }
        }

        return res;
    }
}
