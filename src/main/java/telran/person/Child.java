package telran.person;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
public class Child extends Person
{
	String garten;

	public Child(int id, String name, Address address, LocalDate birthDate, String garten)
	{
		super(id, name, address, birthDate);
		this.garten = garten;
	}

	@Override
	public String toString()
	{
		return "Child [garten=" + garten + "]" + super.toString();
	}
	
	
}
