@Table(name = "persons")
public class Person {
    @Id
    private int id;
    @Index(unique = true)
    private String email;
    @Index
    private String lastName;
    @Index
    private String address;
    @Index(unique = true)
    private int passportNumber;
}
