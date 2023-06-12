package telran.library.model;


import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.PickRecord;
import telran.library.entities.Reader;
import telran.library.utils.Persistable;

import java.io.*;
import java.time.LocalDate;
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
    public BooksReturnCode addBookItem(Book book) {
        if(book.getPickPeriod() < minPickPeriod){
            return BooksReturnCode.PICK_PERIOD_LESS_MIN;
        } else if (book.getPickPeriod() > maxPickPeriod){
            return BooksReturnCode.PICK_PERIOD_GREATER_MAX;
        }
        return books.putIfAbsent(book.getIsbn(), book) == null ? BooksReturnCode.OK : BooksReturnCode.BOOK_ITEM_EXISTS;
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
        if(book == null){
            return BooksReturnCode.NO_BOOK_ITEM;
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


}
