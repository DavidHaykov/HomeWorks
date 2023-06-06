package org.example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class BooksRestoreAppl {
    public static void main(String[] args) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("books.data"))){
            List<Book> books = (List<Book>) in.readObject();
            books.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
