package telran.book.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class BooksRestoreAppl
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("book.data")))
		{
			List<Book> persons = (List<Book>) in.readObject();
			persons.forEach(System.out:: println);
		}
	}
}
