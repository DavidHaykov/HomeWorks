package telran.person;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
public class Address implements Serializable
{
	String city;
	String street;
	int building;
	
	public Address(String city, String street, int building)
	{
		super();
		this.city = city;
		this.street = street;
		this.building = building;
	}
	@Override
	public String toString()
	{
		return "Address [city=" + city + ", street=" + street + ", building=" + building + "]";
	}
}
