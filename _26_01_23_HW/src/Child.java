import java.util.Objects;

public class Child extends Person{
   private String kinderGarden;

    public Child(String name, int age, boolean married, String kinderGarden) {
        super(name, age, married);
        if(kinderGarden!=null&&!kinderGarden.isEmpty()) {
            this.kinderGarden = kinderGarden;
        }else{
            System.out.println("No kinder garden");
        }
    }
    public Child(String name, int age, String kinderGarden){
        super(name, age);
        if(kinderGarden!=null&&!kinderGarden.isEmpty()) {
            this.kinderGarden = kinderGarden;
        }else{
            System.out.println("No kinder garden");
        }
    }

    public String getKinderGarden() {
        return kinderGarden;
    }

    public void setKinderGarden(String kinderGarden) {
        if(kinderGarden!=null&&!kinderGarden.isEmpty()) {
            this.kinderGarden = kinderGarden;
        }else{
            System.out.println("No kinder garden");
        }
    }

    @Override
    public String toString() {
        return "Child{" +
                "kinderGarden='" + kinderGarden + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", married=" + isMarried() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Child child = (Child) o;
        return Objects.equals(kinderGarden, child.kinderGarden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kinderGarden);
    }
}

