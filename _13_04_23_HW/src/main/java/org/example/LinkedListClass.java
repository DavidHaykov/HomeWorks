package org.example;

import java.util.*;
import java.util.function.Predicate;

public class LinkedListClass extends AbstractList {
    private LinkedList<Integer> numbers;
    public LinkedListClass(Collection<Integer> numbers) {
        super(numbers);
        this.numbers = new LinkedList<>(numbers);
    }

    @Override
    public void removeDividedBy(int number) {
        ListIterator<Integer> iterator = numbers.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() % number == 0) {
                iterator.remove();
            }
        }
    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive) {
        ListIterator<Integer> iterator = numbers.listIterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num >= fromInclusive && num < toExclusive) {
                iterator.remove();
            }
        }
    }
}

