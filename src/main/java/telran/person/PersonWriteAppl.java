package telran.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class PersonWriteAppl
{
	private static final long N_PERSONS = 100;
	private static final int EMPL_PROBABILITY = 40;
	private static final int MIN_CHILD_YEAR = 2005;
	private static final int MAX_CHILD_YEAR = 2023;
	private static final int N_GARTEN = 5;
	private static final int N_CITIES = 3;
	private static final int MIN_EMP_YEAR = 1950;
	private static final int MAX_EMP_YEAR = 2004;
	private static final int N_COMPANIES = 5;
	private static final int MIN_SALARY = 5000;
	private static final int MAX_SALARY = 100000;
	private static final String FILE_NAME = "persons.data";
	
	private static final Random gen = new Random();
	static int counter = 1;
	static String[] titles = {"WageManager", "SaleManager", "Manager", "Accountant"};

	public static void main(String[] args) throws IOException {
		List<Person> list = getRandomPersons();
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		//mapper.writeValue(new File(FILE_NAME), list.toArray(new Person[0]));
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), list.toArray(new Person[0]));
	}

	private static List<Person> getRandomPersons()
	{
		return Stream.generate(() -> getRandomPerson()).limit(N_PERSONS).toList();
	}

	private static Person getRandomPerson()
	{
		Person p = getRandomCommonPerson();
		return getRandomNumber(1, 100) <= EMPL_PROBABILITY ? getRandomEmployee(p) : getRandomChild(p);
	}

	private static Person getRandomChild(Person p)
	{
		LocalDate birthDate = getRandomBirthDate(MIN_CHILD_YEAR, MAX_CHILD_YEAR);
		String garten = "garten" + getRandomNumber(1, N_GARTEN);
		return new Child(p.id, p.name, p.address, birthDate, garten);
	}

	private static Person getRandomEmployee(Person p)
	{
		LocalDate birthDate = getRandomBirthDate(MIN_EMP_YEAR, MAX_EMP_YEAR);
		String company = "company" + getRandomNumber(1, 10);
		int salary = getRandomNumber(MIN_SALARY, MAX_SALARY);
		String title = titles[getRandomNumber(0, titles.length-1)];
		return new Employee(p.id, p.name, p.address, birthDate, company, salary, title);
	}

	private static LocalDate getRandomBirthDate(int min, int max)
	{
		int year = getRandomNumber(min, max);
		int month = getRandomNumber(1, 12);
		int day = getRandomNumber(1, 28);
		return LocalDate.of(year, month, day);
	}

	private static Person getRandomCommonPerson()
	{
		int id = counter;
		counter++;
		String name = "name" + getRandomNumber(1, 50);
		Address address = getRandomAddress();
		return new Person(id, name, address, null);
	}

	private static Address getRandomAddress()
	{
		String city = "city" + getRandomNumber(1, N_CITIES);
		String street = "street" + getRandomNumber(1, 50);
		int building = getRandomNumber(1, 10000);
		return new Address(city, street, building);
	}

	private static int getRandomNumber(int min, int max)
	{
		return gen.ints(min, max+1).findFirst().getAsInt();
	}

	
}
