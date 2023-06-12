package telran.library.model;


import org.junit.jupiter.api.Test;
import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.PickRecord;
import telran.library.entities.Reader;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface ILibrary extends Serializable {
BooksReturnCode addBookItem(Book book);
BooksReturnCode addReader(Reader reader);
Reader getReader(int readerId);
Book getBookItem(long isbn);
BooksReturnCode addBookExemplars(long isbn, int amount);
//sprint 2
BooksReturnCode pickBook(long isbn, int readerId, LocalDate pickDate);
List<Book> getBooksPickedByReader(int readerId);
List<Reader> getReadersPickedBook(long isbn);
List<Book> getBooksAuthor(String authorName);
List<PickRecord> getPickRecordsAtDates(LocalDate dateFrom, LocalDate dateTo);


}
