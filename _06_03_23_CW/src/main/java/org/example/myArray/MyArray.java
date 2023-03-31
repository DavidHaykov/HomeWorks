package org.example.myArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyArray <T> implements IArray <T>{

    private static final int DEFAULT_CAPACITY = 16;

    private Object[] array;

    private int size = 0;

    public MyArray(int capacity){
        array = new Object[capacity];
    };

    public MyArray(){
        array = new Object[DEFAULT_CAPACITY];
    }

    private void allocateArray(){
        array = Arrays.copyOf(array, array.length + DEFAULT_CAPACITY);
    }
    @Override
    public void addAll(MyArray<T> other, int index){
        System.out.println(Arrays.toString(array));
        Object[] newArray = new Object[array.length+other.size()];
        for(int i = 0, j = 0; j< other.size();i++){
            if(i<index){
                newArray[i]=array[i];
            }
            if(i>=index){
                newArray[i] = other.get(j);
                j++;

            }
        }
        array = newArray;
        System.out.println(Arrays.toString(array));
    }
    @Override
    public boolean removeAll(T obj){
        boolean res = false;
        Object[] newArray = new Object[array.length];
        System.out.println(Arrays.toString(array));
        for(int i = 0, j=0;i< size-j;i++){
            if(!array[i].equals(obj)){
                newArray[j]=array[i];
                j++;
            }else
                res = true;
        }
        array = newArray;
        System.out.println(Arrays.toString(array));

        return res;
    }

    @Override
    public void addAll(MyArray<T> other) {
        Object[] newArray = Arrays.copyOf(array, size + other.size());
        System.arraycopy(other.array, 0, newArray, size, other.size());
        array = newArray;
        System.out.println(Arrays.toString(array));
    }

    @Override
    public boolean add(T obj) {
        if(obj == null){
            return false;
        }
        if(size == array.length){
            allocateArray();
        }
        array[size]= obj;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T obj) {
        if(index<0||index>size||obj==null)
            return false;
        if(size == array.length)
            allocateArray();
        Object[] res = Arrays.copyOf(array,size+1);

        if (size - index >= 0) System.arraycopy(res, index, array, index + 1, size - index);
        array[index] = obj;
        return true;
    }

    @Override
    public boolean set(T obj, int index) {
        if (index < 0 || index >= array.length) {
            return false;
        }
        try {
            array[index] = obj;
            return true;
        } catch (ArrayStoreException e) {
            return false;
        }

    }
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if(index<0||index>=size)
            return null;
        return (T) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T obj) {
        for(int i = 0; i< size; i++){
            if(array[i].equals(obj))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T obj) {
        for(int i = size-1; i >=0; i--){
            if(array[i].equals(obj))
                return i;
        }
        return -1;
    }

    @Override
    public Object remove(int index) {
        if(index < 0|| index >= size ){
            return null;
        }
        Object res = array[index];
        if(index < size-1)
            System.arraycopy(array, index+1, array, index, size-index-1);
        size--;
        return res;
    }

    @Override
    public boolean remove(T obj) {
        if(obj==null)
            return false;
        return remove(indexOf(obj))!=null;
    }

    @Override
    public boolean contains(T obj) {
        if(indexOf(obj)==-1)
            return false;

        return true;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
    @SuppressWarnings("unchecked")
    @Override
    public void sort(Comparator <T> comp){
        boolean flag = true;
        int index = size - 1;
        do {
            flag = true;
            for(int i = 0; i< index; i++){
                if(comp.compare((T)array[i], (T)array[i+1])>0){
                    swap(i,i+1);
                    flag = false;
                }
            }
            index--;
        } while (!flag);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean removeIf(Predicate<T> pred) {
        boolean res = false;
        for(int i = 0; i<size; i++){
            if(pred.test((T) array[i])){
               remove((T) array[i]);
                res = true;
            }
        }
        return res;
    }
    @SuppressWarnings("unchecked")
    @Override
    public int indexOf(Predicate<T> pred) {
        for(int i = 0; i< size; i++){
            if(pred.test((T) array[i])){
                return i;
            }
        }
        return -1;
    }
    @SuppressWarnings("unchecked")
    @Override
    public int lastIndexOf(Predicate<T> pred) {
        for(int i = size-1; i> 0; i--){
            if(pred.test((T) array[i])){
              return i;
            }

        }
        return -1;
    }
    @SuppressWarnings("unchecked")
    private void swap(int i,int j){
        T temp = (T) array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyArrayIterator();
    }
    private class MyArrayIterator implements  Iterator <T>{
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex< size;       // for(int i = 0; I < SIZE; i ++)
        }
        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T)array[currentIndex++];
        }
    }
}

