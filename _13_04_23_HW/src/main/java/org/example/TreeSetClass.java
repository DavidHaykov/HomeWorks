package org.example;

import java.util.Collection;
import java.util.TreeSet;
import java.util.function.Predicate;

public class TreeSetClass extends AbstractSet{


    public TreeSetClass(Collection<Integer> numbers) {

        numbers = new TreeSet<>();
    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive) {

    }
    public void display() {
        System.out.println(numbers);
    }

}