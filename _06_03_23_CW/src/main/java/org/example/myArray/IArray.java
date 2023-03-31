package org.example.myArray;

import java.util.Comparator;
import java.util.function.Predicate;

public interface IArray <T> extends Iterable<T>{
    boolean add(T obj);
    //boolean add(int index, T obj);
    boolean add(int index, T obj);
    boolean set (T obj, int index);
    void addAll(MyArray<T> other);
     boolean removeAll(T obj);
    void addAll(MyArray<T> other, int index);
    T get(int index);
    int size();
    int indexOf(T obj);
    int lastIndexOf(T obj);
    Object remove(int index);
    boolean remove(T obj);
    boolean contains(T obj);
    Object[] toArray();

    void sort (Comparator<T> comp) ;

    //HW 16.03   tests
    boolean removeIf(Predicate<T> pred);
    int indexOf(Predicate<T> pred);
    int lastIndexOf(Predicate<T> pred);



}
