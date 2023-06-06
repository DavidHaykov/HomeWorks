package org.example;

import java.time.LocalDate;

public class LiteratureBook extends Book{
    Genre genre;

    public LiteratureBook(long isbn, String author, CoverType cover, int pages, LocalDate publishDate, String tittle, Genre genre) {
        super(isbn, author, cover, pages, publishDate, tittle);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "LiteratureBook{" +
                "genre=" + genre +
                ", isbn=" + isbn +
                ", author='" + author + '\'' +
                ", cover=" + cover +
                ", pages=" + pages +
                ", publishDate=" + publishDate +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}
