import java.sql.SQLOutput;
import java.util.SortedMap;

public class PersonAppl {
    public static void main(String[] args) {
        Person person = new Person("Maniak", 32, false);
        Employee employee1 = new Employee("Jhonson", 40, true, "Bastards LTD", 300);
        Employee employee2 = new Employee("Manson", 34, false, "Crazy chicken", 250);
        Employee employee3 = new Employee("Jhonson", 40, true, "Bastards LTD", 300);
        Child child = new Child("Melkiy Gnom",4, "Mini Bastards" );

        Person[] arr = {
                person,
                (Person) employee1,
                employee2,
                employee3,
                child
        };
        printEmployes(arr);

    }

    public static void printEmployes(Person[] arr){
        for (Person person : arr) {
            if (person instanceof Employee) {
                System.out.println(((Employee) person).getName() + "  salary = " + ((Employee) person).computeSalary(25));
            }
        }

    }

}
