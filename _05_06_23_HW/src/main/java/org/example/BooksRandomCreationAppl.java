package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class BooksRandomCreationAppl {
    private static final String[] TECHNOLOGIES = {"Programming" ,"Fundamental Science","Electricity", "Java dev", "Rybolovstvo"};
    private static final Genre[] GENERS = Genre.values();
    private static final CoverType[] COVER_TYPES = CoverType.values();
    private static final long N_BOOKS = 200;
    private static final int TECH_PROBABILITY = 30;
    private static final int MIN_PG = 70;
    private static final int MAX_PG = 600;
    private static final int N_AUTHORS = 23;
    private static final int MIN_YEAR = 1800;
    private static final int MAX_YEAR = 2023;

    private static final Random gen = new Random();
    static int counter = 1;
    public static void main(String[] args) {
        List<Book> books = getRandomBooks();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("books.data"))){
            out.writeObject(books);
        } catch (IOException e1){
            e1.printStackTrace();
        }
    }
    private static List<Book> getRandomBooks() {
        return Stream.generate(() -> getRandomBook()).limit(N_BOOKS).toList();
    }
    private static Book getRandomBook(){
        Book book = getRandomCommonBook();
        return getRandomNumber(1,100) < TECH_PROBABILITY ? getRandomTechBook(book) : getRandomLiteratureBook(book);
    }
    private static Book getRandomTechBook(Book book){
        String technology = TECHNOLOGIES[getRandomNumber(0, TECHNOLOGIES.length-1)];
        return new TechnicalBook(book.isbn,book.author,book.cover,book.pages,book.publishDate, book.tittle, technology);
    }
    private static Book getRandomLiteratureBook(Book book){
        Genre genre = GENERS[getRandomNumber(0, GENERS.length-1)];
        return new LiteratureBook(book.isbn, book.author, book.cover, book.pages, book.publishDate, book.tittle, genre);
    }
    private static Book getRandomCommonBook(){
        long isbn = counter;
        counter++;
        String author = "author" + getRandomNumber(1, 20);
        CoverType coverType = COVER_TYPES[getRandomNumber(0, COVER_TYPES.length-1)];
        int pages = getRandomNumber(MIN_PG, MAX_PG);
        LocalDate publisdate = getRandomPublishDate(MIN_YEAR, MAX_YEAR);
        String tittle = "tittle" + getRandomNumber(1, N_AUTHORS);

        return new Book(isbn, author, coverType, pages, publisdate, tittle);
    }
    private static LocalDate getRandomPublishDate(int min, int max){
        int year = getRandomNumber(min, max);
        int month = getRandomNumber(1,12);
        int days = getRandomNumber(1,28);
        return LocalDate.of(year, month, days);
    }

    private static int getRandomNumber(int min, int max) {
        return gen.ints(min, max+1).findFirst().getAsInt();
    }

}
