package org.example;

import java.util.Comparator;

public class WeigthComporator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return Double.compare(o1.weight, o2.weight);
    }
}
