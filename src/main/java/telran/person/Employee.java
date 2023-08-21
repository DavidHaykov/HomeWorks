package telran.person;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
public class Employee extends Person
{
	String company;
	int salary;
	String title;
	
	public Employee(int id, String name, Address address, LocalDate birthDate, String company, int salary, String title)
	{
		super(id, name, address, birthDate);
		this.company = company;
		this.salary = salary;
		this.title = title;
	}
	@Override
	public String toString()
	{
		return "Employee [company=" + company + ", salary=" + salary + ", title=" + title + "]" + super.toString();
	}
}
