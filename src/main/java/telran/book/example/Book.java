package telran.book.example;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Book implements Serializable
{
	long isbn;
	String author;
	CoverType cover;
	int pages;
	LocalDate publishDate;
	String title;

	public Book(long isbn, String auther, CoverType cover, int pages, LocalDate publishDate, String title)
	{
		super();
		this.isbn = isbn;
		this.author = auther;
		this.cover = cover;
		this.pages = pages;
		this.publishDate = publishDate;
		this.title = title;
	}

	public long getIsbn()
	{
		return isbn;
	}

	public String getAuthor()
	{
		return author;
	}

	public CoverType getCover()
	{
		return cover;
	}

	public int getPages()
	{
		return pages;
	}

	public LocalDate getPublishDate()
	{
		return publishDate;
	}

	public String getTitle()
	{
		return title;
	}

	@Override
	public String toString()
	{
		return "Book [ISBN=" + isbn + ", author=" + author + ", cover=" + cover + ", pages=" + pages + ", publishDate="
				+ publishDate + ", title=" + title + "]";
	}
}
