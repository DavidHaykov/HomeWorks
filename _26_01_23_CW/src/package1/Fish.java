package package1;

import java.util.Objects;

public class Fish extends Animal{
    private boolean reproduction;

    public Fish(String name, int age, boolean reproduction) {
        super(name, age);
        this.reproduction = reproduction;
    }

    public Fish(boolean reproduction) {
        this.reproduction = reproduction;
    }

    public boolean isReproduction() {
        return reproduction;
    }

    public void setReproduction(boolean reproduction) {
        this.reproduction = reproduction;
    }
    public void fishVoice(){

        System.out.println("Bulk Bulk");
    }

    @Override
    public String toString() {
        String s = reproduction ? "eggs " : "whitebaits";


        return "Fish{" +
                "reproduction=" + s +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
    @Override
    public void voice(){
        System.out.println("Bulk bulk");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return reproduction == fish.reproduction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), reproduction);
    }
}
