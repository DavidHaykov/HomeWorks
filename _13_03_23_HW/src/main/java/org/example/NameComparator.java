package org.example;

import java.util.Comparator;

public class NameComparator implements Comparator<Cat> {


    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.name.compareTo(o2.name);

    }
}
