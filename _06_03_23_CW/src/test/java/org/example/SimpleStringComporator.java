package org.example;

public class SimpleStringComporator implements java.util.Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
