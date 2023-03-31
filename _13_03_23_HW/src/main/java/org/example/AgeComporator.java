package org.example;

import java.util.Comparator;

public class AgeComporator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return Integer.compare(o1.age, o2.age);
    }
}
