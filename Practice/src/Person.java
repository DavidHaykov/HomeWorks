
public class Person {
	//Fields
	private String firstName; //firstName ---> first_name;
	private String lastName; // null
	private int age;
	private int height;
	private int weight;
	private char gender;
	
	public Person() {
		
	}

	public Person(String firstName, String lastName, int age, int height, int weight, char gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public char getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ "]";
	}
}
