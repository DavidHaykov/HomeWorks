package telran.library.model;


import org.junit.jupiter.api.Test;
import telran.library.entities.*;

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

//sprint 3
RemovedBookData removeBook (long isbn);
List<RemovedBookData> removeBooksOfAuthor(String author);
RemovedBookData returnBook(long isbn, int readerId, LocalDate returnDate);

//sprint 4
List<ReaderDelay> getReadersDelayingBooks(LocalDate currentDate);
List<ReaderDelay> getReadersDelayedBook();
List<Book> getMostPopularBooks(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge);
List<String> getMostPopularAuthors();
List<Reader> getMostActiveReaders(LocalDate fromDate, LocalDate toDate);

List<String> getAuthorNames();


}
