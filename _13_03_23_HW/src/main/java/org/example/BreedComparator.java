package org.example;

import java.util.Comparator;

public class BreedComparator implements Comparator<Cat> {


    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.breed.compareTo(o2.breed);
    }
}
