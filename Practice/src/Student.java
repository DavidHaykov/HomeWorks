// OOP
// Object Oriented Programming
// Inheritance - наследование
// Incapsulation - инкапсуляция
// Polymorphism - полиморфизм

public class Student extends Person {
	private String schoolName;
	
	public Student(String firstName, String lastName, int age, int height, int weight, char gender, String schoolName) {
		super(firstName, lastName, age, height, weight, gender);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}
}
