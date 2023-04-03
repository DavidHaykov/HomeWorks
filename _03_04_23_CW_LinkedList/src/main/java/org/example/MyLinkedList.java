package org.example;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class MyLinkedList <T> implements IArray<T> {
    private static class Node <T>  {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    int size;
    Node<T> head;
    Node<T> tail;


    @Override
    public boolean add(T obj) {
        return false;
    }

    @Override
    public boolean add(int index, T obj) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int indexOf(T obj) {
        return 0;
    }

    @Override
    public int lastIndexOf(T obj) {
        return 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T obj) {
        return false;
    }

    @Override
    public boolean contains(T obj) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean set(T obj, int index) {
        return false;
    }

    @Override
    public void addAll(IArray<T> other) {

    }

    @Override
    public void addAll(int index, IArray<T> other) {

    }

    @Override
    public boolean removeAll(T obj) {
        return false;
    }

    @Override
    public void sort(Comparator<T> comp) {

    }

    @Override
    public boolean removeIf(Predicate<T> pred) {
        return false;
    }

    @Override
    public int indexOf(Predicate<T> pred) {
        return 0;
    }

    @Override
    public int lastIndexOf(Predicate<T> pred) {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
