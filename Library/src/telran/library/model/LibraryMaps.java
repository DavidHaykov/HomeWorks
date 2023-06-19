package telran.library.model;


import telran.library.entities.*;
import telran.library.entities.Reader;
import telran.library.utils.Persistable;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class LibraryMaps extends AbstractLibrary implements Persistable {
    private HashMap<Long, Book> books;
    private HashMap<Integer, Reader> readers;
    //sprint 2
    private TreeMap<LocalDate, List<PickRecord>> records;
    private HashMap<Long, List<PickRecord>> bookRecords;
    private HashMap<Integer, List<PickRecord>> readerRecords;
    private HashMap<String, List<Book>> authorBooks;

    @Override
    public void save(String fileName) throws IOException {
        try( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(this);
        } catch (Exception e){
            System.out.println("Error in save method " + e.getMessage());
        }
    }

    public static ILibrary restoreFromFile(String fileName){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            return (ILibrary) in.readObject();
        }catch (Exception e){
            System.out.println("Error in reading method " + e.getMessage());
            return null;
        }
    }
    @Override
    public BooksReturnCode addBookItem(Book book) {
        if (!authorBooks.containsKey(book.getAuthor())) {
            return BooksReturnCode.NO_AUTHOR;
        }
        boolean res = books.putIfAbsent(book.getIsbn(), book) == null;
        if (!res) {
            return BooksReturnCode.BOOK_EXIST;
        }
        addToAuthorsBook(book);

        return BooksReturnCode.OK;
    }
    private void addToAuthorsBook(Book book){
        String author = book.getAuthor();
        List<Book> list = authorBooks.getOrDefault(author, new ArrayList<>());
        list.add(book);
        authorBooks.putIfAbsent(author, list);
    }

    @Override
    public BooksReturnCode addReader(Reader reader) {
        return readers.putIfAbsent(reader.getReaderId(), reader) == null ? BooksReturnCode.OK : BooksReturnCode.READER_EXISTS;
    }

    @Override
    public Reader getReader(int readerId) {
        return readers.get(readerId);
    }

    @Override
    public Book getBookItem(long isbn) {
        return books.get(isbn);
    }

    @Override
    public BooksReturnCode addBookExemplars(long isbn, int amount) {
        if(!books.containsKey(isbn)){
            return BooksReturnCode.NO_BOOK_ITEM;
        }else {
            int currentAmount = books.get(isbn).getAmount();
            books.get(isbn).setAmount(amount + currentAmount);
            return BooksReturnCode.OK;
        }
    }

    @Override
    public BooksReturnCode pickBook(long isbn, int readerId, LocalDate pickDate) {
        Book book = getBookItem(isbn);
        if(book == null  || book.getAmount() == -1){
            return BooksReturnCode.NO_BOOK_ITEM;
        }
        List<PickRecord> list = readerRecords.get(readerId).stream()
                .filter(pr -> {
                    return pr.getIsbn() == isbn || pr.getReturnDate() == null;
                }).toList();

        if(!list.isEmpty()){
            return BooksReturnCode.READER_READ_IT;
        }
        if(book.getAmount() == book.getAmountInUse()){
            return BooksReturnCode.BOOK_IN_USE;
        }
        if(!readers.containsKey(readerId)){
            return BooksReturnCode.NO_READER;
        }
        PickRecord record = new PickRecord(isbn, readerId, pickDate);
        addToBookRecords(record);
        addToReaderRecords(record);
        addToRecords(record);
        book.setAmountInUse(book.getAmountInUse()+1);
        return BooksReturnCode.OK;
    }

    private void addToRecords(PickRecord record) {
        LocalDate date = record.getPickDate();
        List<PickRecord> list = records.getOrDefault(date, new ArrayList<>());
        list.add(record);
        records.putIfAbsent(date, list);
    }

    private void addToReaderRecords(PickRecord record) {
        int id = record.getReaderId();
        List<PickRecord> list = readerRecords.getOrDefault(id, new ArrayList<>());
        list.add(record);
        readerRecords.putIfAbsent(id, list);

    }

    private void addToBookRecords(PickRecord record) {
        long isbn = record.getIsbn();
        List<PickRecord> list = bookRecords.getOrDefault(isbn, new ArrayList<>());
        list.add(record);
        bookRecords.putIfAbsent(isbn, list);
    }

    @Override
    public List<Book> getBooksPickedByReader(int readerId) {
        return readerRecords.getOrDefault(readerId, new ArrayList<>()).stream()
                .map(pr -> getBookItem(pr.getIsbn()))
                .distinct()
                .toList();
    }

    @Override
    public List<Reader> getReadersPickedBook(long isbn) {
        return bookRecords.getOrDefault(isbn, new ArrayList<>()).stream()
                .map(pr -> getReader(pr.getReaderId()))
                .distinct()
                .toList();
    }

    @Override
    public List<Book> getBooksAuthor(String authorName) {
        return authorBooks.getOrDefault(authorName, new ArrayList<>()).stream()
                .filter(b -> b.getAmountInUse() < b.getAmount()).toList();
    }

    @Override
    public List<PickRecord> getPickRecordsAtDates(LocalDate dateFrom, LocalDate dateTo) {
        Collection<List<PickRecord>> col = records.subMap(dateFrom, dateTo).values();
        return col.stream()
                .flatMap(Collection::stream).toList();
    }

    @Override
    public RemovedBookData removeBook(long isbn) {
        Book book = getBookItem(isbn);
        if( book == null){
            return null;
        }
        if(book.getAmountInUse() > 0){
            book.setAmount(-1);
        }


        return book.getAmountInUse() > 0 ? new RemovedBookData(book, null) : actualBookRemove(book);
    }

    private RemovedBookData actualBookRemove(Book book) {
        long isbn = book.getIsbn();
        List<PickRecord> list = bookRecords.get(isbn);
        books.remove(isbn);
        bookRecords.remove(isbn);
        removeFromAuthorsRecords(book);
        removeFromRecords(list);
        removeFromReaders(list);
        return new RemovedBookData(book, list);
    }

    private void removeFromReaders(List<PickRecord> list) {
        list.forEach(pr -> readerRecords.get(pr.getReaderId()).remove(pr));
    }

    private void removeFromRecords(List <PickRecord> list) {
        list.forEach(pr -> records.get(pr.getPickDate()).remove(pr));
    }

    private void removeFromAuthorsRecords(Book book) {
        authorBooks.get(book.getAuthor()).remove(book);
    }

    @Override
    public List<RemovedBookData> removeBooksOfAuthor(String author) {
        List<Book> list = authorBooks.get(author);
        if(!list.isEmpty()){
            return list.stream()
                    .map(b -> removeBook(b.getIsbn()))
                    .toList();
        }
        return new ArrayList<>();
    }

    @Override
    public RemovedBookData returnBook(long isbn, int readerId, LocalDate returnDate) {
        PickRecord record = readerRecords.get(isbn)
                .stream()
                .filter(pr -> pr.getIsbn() == isbn && pr.getReturnDate() == null)
                .findFirst()
                .orElse(null);
        if(record == null){
            return null;
        }

        Book book = getBookItem(isbn);
        updateRecord(record, returnDate, book);
        book.setAmountInUse(book.getAmountInUse() - 1);
        return book.getAmount() == -1 && book.getAmountInUse() == 0 ? actualBookRemove(book) : new RemovedBookData(book, null);
    }

    private void updateRecord(PickRecord record, LocalDate returnDate, Book book) {
        long realPickDays = ChronoUnit.DAYS.between(record.getPickDate(), returnDate);
        int delay = realPickDays > book.getPickPeriod() ? (int)(realPickDays - book.getPickPeriod()) : 0;
        record.setReturnDate(returnDate);
        record.setDelayDays(delay);
    }


}
