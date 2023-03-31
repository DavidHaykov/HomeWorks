import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private boolean married;

    public Person(String name, int age, boolean married) {
        if(name!=null&&!name.isEmpty()) {
            this.name = name;
        }else{
            System.out.println("Wrong name");
        }
        if(age>=18&&age<120) {
            this.age = age;
        }else{
            System.out.println("Wrong age");
        }
        this.married = married;
    }

    public Person(String name, int age) {
        if(name!=null&&!name.isEmpty()) {
            this.name = name;
        }else{
            System.out.println("Wrong name");
        }
        if(age>0&&age<18) {
            this.age = age;
        }else{
            System.out.println("Wrong age");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name!=null&&!name.isEmpty()) {
            this.name = name;
        }else{
            System.out.println("Wrong name");
        }
    }
    public void display(){

        System.out.println(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>0&&age<120) {
            this.age = age;
        }else{
            System.out.println("Wrong age");
        }
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        String marr = married?"Married":"Not married";
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", married=" + marr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && married == person.married && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, married);
    }
}
