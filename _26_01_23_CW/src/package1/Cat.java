package package1;

public class Cat extends Animal{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public Cat(String color) {
        this.color = color;
    }
    public void catVoice(){

        System.out.println("Mau mau");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
    @Override
    public void voice(){
        System.out.println("Mau mau");
    }

}
