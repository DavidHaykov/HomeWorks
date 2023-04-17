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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        Object[] res = new Object[size];
        int index = 0;
        for(int i = 0; i < table.length; i++){
            if(table[i] == null || table[i].isEmpty()){
                continue;
            }
            for(Object o : table[i]){
                res[index] = o;
                index++;
            }
        }
        return res;
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
        capacity += 16;
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

        for(Object o : c){
            if(!contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean added = false;
        for (E e : c) {
            if (add(e)) {
                added = true;
            }
        }
        return added;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        for(Object e : c){
            if(remove(e)){
                removed = true;
            }
        }
        return  removed;
    }

    @Override
    public void clear() {
        for(int i = 0; i< table.length; i++){
            if(table[i] != null){
                table[i].clear();
            }
            size = 0;
        }
    }
}
