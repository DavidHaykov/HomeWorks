package org.example.myString;

import java.util.Iterator;

public class MyStrIterator implements Iterator<Character> {
    private StringBuilder str;
    private int size;
    private int current;
    public MyStrIterator(StringBuilder str) {
        this.str = str;
        size = str.length();
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return current<size;
    }

    @Override
    public Character next() {
        return str.charAt(current++);
    }

    @Override
    public void remove(){
        str.deleteCharAt(--current);
        size--;
    }

}
