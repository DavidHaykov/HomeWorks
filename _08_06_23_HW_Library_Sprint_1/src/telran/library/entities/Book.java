package telran.library.entities;


import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Predicate;

@SuppressWarnings("serial")
public class Book implements Serializable {
    private long isbn;
    private String tittle;
    private String author;
    private int amount;
    private int amountInUse;
    private int pickPeriod;

    public Book() {
    }

    public Book(long isbn, String tittle, String author, int amount, int pickPeriod) {
        this.isbn = isbn;
        this.tittle = tittle;
        this.author = author;
        this.amount = amount;
        this.pickPeriod = pickPeriod;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTittle() {
        return tittle;
    }

    public String getAuthor() {
        return author;
    }

    public int getAmount() {
        return amount;
    }

    public int getAmountInUse() {
        return amountInUse;
    }

    public int getPickPeriod() {
        return pickPeriod;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAmountInUse(int amountInUse) {
        this.amountInUse = amountInUse;
    }

    public void setPickPeriod(int pickPeriod) {
        this.pickPeriod = pickPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", tittle='" + tittle + '\'' +
                ", author='" + author + '\'' +
                ", amount=" + amount +
                ", amountInUse=" + amountInUse +
                ", pickPeriod=" + pickPeriod +
                '}';
    }
}
