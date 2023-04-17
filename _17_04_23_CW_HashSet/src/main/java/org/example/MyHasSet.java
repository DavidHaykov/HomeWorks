package org.example;

import java.util.*;



public class MyHasSet<E> implements Set<E> {
    List<E>[] table;
    int size;
    int capacity;
    double loadFactor;


    public MyHasSet(int capacity, double loadFactor) {
        table = new LinkedList[capacity];
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public MyHasSet(int capacity) {
        table = new LinkedList[capacity];
        this.capacity = capacity;
        this.loadFactor = 0.75;
    }

    public MyHasSet(){
        this(16,0.75);
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(contains(e)) {
            return false;
        }
        if(capacity*loadFactor<size()){
            recreation();
        }
        int index = getIndex(e);
        if(table[index]==null){
            table[index] = new LinkedList<>();
        }
        table[index].add(e);
        size++;
        return true;

    }

    private int getIndex(E e) {

        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
