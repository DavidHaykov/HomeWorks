package telran.book.example;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class TechnicalBook extends Book
{
	String technology;

	public TechnicalBook(long isbn, String auther, CoverType cover, int pages, LocalDate publishDate, String title,
			String technology)
	{
		super(isbn, auther, cover, pages, publishDate, title);
		this.technology = technology;

	}

	public String getTechnology()
	{
		return technology;
	}

	@Override
	public String toString()
	{
		return "TechnicalBook [technology=" + technology + ", isbn=" + isbn + ", auther=" + author + ", cover=" + cover
				+ ", pages=" + pages + ", publishDate=" + publishDate + ", title=" + title + "]";
	}
}
