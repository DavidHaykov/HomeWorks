package package1;

public class Dog extends Animal{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Dog(String breed) {
        this.breed = breed;


    }
    public void dogVoice(){

        System.out.println("Gav gav");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
    @Override
    public void voice(){
        System.out.println("Gav gav");
    }
}
