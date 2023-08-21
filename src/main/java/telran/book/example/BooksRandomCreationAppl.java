package telran.book.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BooksRandomCreationAppl
{
	private static final long N_BOOKS = 1_000;
	private static final int LITBOOK_PROBABILITY = 75;
	private static Random gen = new Random();

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		List<Book> books = getRandomBooks();
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("book.data")))
		{
			out.writeObject(books);
		}
	}

	private static List<Book> getRandomBooks()
	{
		return Stream.generate(BooksRandomCreationAppl::getRandomBook)
				.limit(N_BOOKS).collect(Collectors.toList());
	}

	private static Book getRandomBook()
	{
		Book book = getCommonBook();
		return getRandomNumber(1, 100) <= LITBOOK_PROBABILITY ? getRandomLitBook(book) : 
			getRandomTechBook(book);
	}

	private static Book getCommonBook()
	{
		long isbn = getRandomNumber(1_000_000_000l, 9_999_999_999l);
		String author = "author" + getRandomNumber(1, 1_000_000);
		CoverType cover = getRandomNumber(1, 100) <= 60 ? CoverType.SOFT : CoverType.SOLID;
		int pages = (int) getRandomNumber(1, 1_500);
		LocalDate publishDate = getRandomYear();
		String title = "Title" + getRandomNumber(1, 1_000);
		return new Book(isbn, author, cover, pages, publishDate, title);
	}

	private static LocalDate getRandomYear()
	{
		int year = (int) getRandomNumber(1850, 2019);
		int month = (int) getRandomNumber(1, 12);
		int day = (int) getRandomNumber(1, 28);
		return LocalDate.of(year, month, day);
	}

	private static long getRandomNumber(long minNum, long maxNum)
	{
		return gen.longs(1, minNum, maxNum).findFirst().getAsLong();
	}

	private static Book getRandomLitBook(Book book)
	{
		Genre genre = getRandomGenre();
		return new LiteratureBook(book.getIsbn(), book.getAuthor(), book.getCover(), 
				book.getPages(), book.getPublishDate(), book.getTitle(), genre);
	}

	private static Genre getRandomGenre()
	{
		Genre[] genres = Genre.values();
		return genres[(int) getRandomNumber(0, genres.length - 1)];
	}

	private static Book getRandomTechBook(Book book)
	{
		String technology = getRandomTech();
		return new TechnicalBook(book.getIsbn(), book.getAuthor(), book.getCover(), 
				book.getPages(), book.getPublishDate(), book.getTitle(), technology);
	}

	private static String getRandomTech()
	{
		String[] tech = { "Programming", "Fundamental Science", "Electricity",
					"Philosophy", "Chemistry" };
		return tech[(int) getRandomNumber(0, tech.length - 1)];
	}
}
