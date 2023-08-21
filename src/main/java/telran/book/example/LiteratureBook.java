package telran.book.example;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class LiteratureBook extends Book
{
	Genre genre;

	public LiteratureBook(long isbn, String auther, CoverType cover, int pages, LocalDate publishDate, String title,
			Genre genre)
	{
		super(isbn, auther, cover, pages, publishDate, title);
		this.genre = genre;
	}

	public Genre getGenre()
	{
		return genre;
	}

	@Override
	public String toString()
	{
		return "LiteratureBook [genre=" + genre + ", ISBN=" + isbn + ", auther=" + author + ", cover=" + cover
				+ ", pages=" + pages + ", publishDate=" + publishDate + ", title=" + title + "]";
	}

}
