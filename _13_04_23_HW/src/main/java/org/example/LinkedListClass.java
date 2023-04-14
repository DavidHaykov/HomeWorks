package org.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Predicate;

public class LinkedListClass extends AbstractList {

    public LinkedListClass() {
        super(new LinkedList<>());
    }

    @Override
    public void removeRepeated() {
        Set<Integer> notRepeated = new HashSet<>(numbers);
        numbers.clear();
        numbers.addAll(notRepeated);
    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive) {
        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= fromInclusive && integer < toExclusive;
            }
        });
    }
}

