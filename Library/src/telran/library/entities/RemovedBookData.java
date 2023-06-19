package telran.library.entities;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
public class RemovedBookData implements Serializable {
    private Book book;
    private List<PickRecord> records;

    public RemovedBookData() {
    }

    public RemovedBookData(Book book, List<PickRecord> records) {
        this.book = book;
        this.records = records;
    }

    public Book getBook() {
        return book;
    }

    public List<PickRecord> getRecords() {
        return records;
    }

    @Override
    public String toString() {
        return "RemovedBookData{" +
                "book=" + book +
                ", records=" + records +
                '}';
    }
}
