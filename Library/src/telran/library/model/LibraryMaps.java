package telran.library.model;


import telran.library.entities.Book;
import telran.library.entities.BooksReturnCode;
import telran.library.entities.Reader;
import telran.library.utils.Persistable;

import java.io.*;
import java.util.HashMap;
import java.util.SortedMap;


public class LibraryMaps extends AbstractLibrary implements Persistable {
    private HashMap<Long, Book> books;
    private HashMap<Integer, Reader> readers;

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
