package org.example;

import java.util.Comparator;
import java.util.function.Predicate;

public interface IArray<T> extends Iterable<T>
{
    boolean add(T obj);
    boolean add(int index, T obj);
    T get(int index);
    int size();
    int indexOf(T obj);
    int lastIndexOf(T obj);
    T remove(int index);
    boolean remove(T obj);
    boolean contains(T obj);
    Object[] toArray();

    boolean set(T obj, int index);
    void addAll(IArray<T> other);
    void addAll(int index, IArray<T> other);
    boolean removeAll(T obj);

    void sort(Comparator<T> comp);

    boolean removeIf(Predicate<T> pred);
    int indexOf(Predicate<T> pred);
    int lastIndexOf(Predicate<T> pred);
    boolean isEmpty();
    void clear();
}