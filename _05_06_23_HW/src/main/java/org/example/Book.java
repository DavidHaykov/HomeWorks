package org.example;

import java.io.Serializable;
import java.time.LocalDate;
@SuppressWarnings("serial")
public class Book implements Serializable {
    long isbn;
    String author;
    CoverType cover;
    int pages;
    LocalDate publishDate;
    String tittle;

    public Book(long isbn, String author, CoverType cover, int pages, LocalDate publishDate, String tittle) {
        this.isbn = isbn;
        this.author = author;
        this.cover = cover;
        this.pages = pages;
        this.publishDate = publishDate;
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", author='" + author + '\'' +
                ", cover=" + cover +
                ", pages=" + pages +
                ", publishDate=" + publishDate +
                ", tittle='" + tittle + '\'' +
                '}';
    }

}
