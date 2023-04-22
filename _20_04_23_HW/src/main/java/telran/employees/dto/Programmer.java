package telran.employees.dto;

import java.util.Objects;
import java.util.Set;

public class Programmer {
    private int id;
    private String name;
    private Set<String> technologies;
    private int salary;

    public Programmer(int id, String name, Set<String> technologies, int salary) {
        this.id = id;
        this.name = name;
        this.technologies = technologies;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getTechnologies() {
        return technologies;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) throws Exception {
        if(salary <= 0) {
            throw new Exception("Not legal salary");
        }
            try {
                this.salary = salary;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public String toString() {
        return  "Programmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technologies=" + technologies +
                ", salary=" + salary +
                '}'  + "\n";
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Programmer programmer)) {
            return false;
        }
        return id == programmer.id;
    }
}
