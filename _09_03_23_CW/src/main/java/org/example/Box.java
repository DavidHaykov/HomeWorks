package org.example;

public class Box <T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Box(T value) {
        this.value = value;
    }
}
//E - element
//K - key
//V - value
//N - number
//T - type



