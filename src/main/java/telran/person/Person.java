package telran.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
public class Person implements Serializable
{
//	private static final long serialVersionUID = 1101486612091199231L;
//	private static final long serialVersionUID = 888L;
	int id;
	String name;
	Address address;
	@JsonFormat(pattern = "dd/MM/yy")
	LocalDate birthDate;
//	transient LocalDate birthDate;
	public Person(int id, String name, Address address, LocalDate birthDate)
	{
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
	}
	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", birthDate=" + birthDate + "]";
	}
}
