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
        if (obj==null) {
            return false;
        }
        Node<T> node = new Node<>(obj, tail, null);
        if(tail==null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        tail = node;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T obj) {
        return false;
    }

    @Override
    public T get(int index) {
        Node<T> node = getNodeByIndex(index);
        return node.data;
    }

    private Node<T> getNodeByIndex(int index) {
        if(index<0||index>=size){
            throw new IllegalArgumentException();
        }
        Node<T> current;
        if(index<=size/2){
            current = head;
            for(int i =0; i< index; i++){
                current = current.next;
            }
        }else{
            current = tail;
            for(int i = size -1; i > index; i--){
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public int size() {
        return size;
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
        Node<T> node = getNodeByIndex(index);
        if(size == 1){
            head = null;
            tail = null;
        } else if (node.prev == null) {
            node.next.prev = null;
            head = head.next;
        } else if (node.next==null) {
            node.prev.next = null;
            tail = tail.prev;
        }else {

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return node.data;
    }

    @Override
    public boolean remove(T obj) {
        return false;
    }

    @Override
    public boolean contains(T obj) {
        return this.indexOf(obj) != -1;
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
