
public class Application {
	public static void main(String[] args) {
		Person person = new Person();
		
		Person student = new Student("Vasya", "Pupkin", 18, 165, 90, 'M', "Nomer13");
		((Student)student).getSchoolName();
		
		Student student1 = new Student("Vasya", "Pupkin", 18, 165, 90, 'M', "Nomer13");
		student1.getGender();
		
		System.out.println(person);
	}
	
	//ctrl + click -> enter class
	//ctrl + O -> find methods in class
	//ctrl + shift + R -> navigate class
}