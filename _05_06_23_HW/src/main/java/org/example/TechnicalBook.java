package org.example;

import java.time.LocalDate;

public class TechnicalBook extends Book {
    String technology;

    public TechnicalBook(long isbn, String author, CoverType cover, int pages, LocalDate publishDate, String tittle, String technology) {
        super(isbn, author, cover, pages, publishDate, tittle);
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "TechnicalBook{" +
                "technology='" + technology + '\'' +
                ", isbn=" + isbn +
                ", author='" + author + '\'' +
                ", cover=" + cover +
                ", pages=" + pages +
                ", publishDate=" + publishDate +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}
