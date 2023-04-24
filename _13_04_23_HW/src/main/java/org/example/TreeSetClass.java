package org.example;

import java.util.Collection;
import java.util.TreeSet;
import java.util.function.Predicate;

public class TreeSetClass extends AbstractSet{


    public TreeSetClass() {

        numbers = new TreeSet<>();
    }

    @Override
    public void removeRepeated() {

    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive) {
        ((TreeSet<Integer>)numbers).subSet(fromInclusive,toExclusive).clear();
    }
    public void display() {
        System.out.println(numbers);
    }

}