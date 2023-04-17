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
        int index = getIndex(o);
        if(table[index] == null) {
            return false;
        }
        return table[index].contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int totalCount = 0;
            int arrayIndex = 0;
            int listIndex = 0;
            @Override
            public boolean hasNext() {
                return totalCount < size;
            }

            @Override
            public E next() {
                while(table[arrayIndex]==null || table[arrayIndex].isEmpty()){
                    arrayIndex++;
                }
                E res = table[arrayIndex].get(listIndex);
                totalCount++;
                if(listIndex < table[arrayIndex].size()-1){
                    listIndex++;
                }else{
                    listIndex = 0;
                    arrayIndex++;
                }
                return null;
            }
        };
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
    public void recreation(){
        LinkedList[] temp = new LinkedList[capacity+16];
        for(int i = 0; i < table.length; i++){
            if(table[i] == null){
                continue;
            }
            for (E obj: table[i]) {
                int index = getIndex(obj);
                if(temp[index] == null){
                    temp[index] = new LinkedList<>();
                }
                temp[index].add(obj);
            }
        }
        table = temp;
    }

    private int getIndex(Object obj) {
        int hash = obj.hashCode();
        return Math.abs(hash) % capacity;
    }

    @Override
    public boolean remove(Object o) {
        if(!contains(o)) {
            return false;
        }
        int index = getIndex(o);
        table[index].remove(o);
        size--;
        return true;

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
