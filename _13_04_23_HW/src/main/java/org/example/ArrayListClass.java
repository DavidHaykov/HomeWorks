package org.example;

import java.util.*;
import java.util.function.Predicate;

public class ArrayListClass extends AbstractList {
    private ArrayList<Integer> numbers;
    public ArrayListClass(Collection<Integer> numbers) {
        super(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public void removeDividedBy(int number) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % number == 0) {
                numbers.remove(i);
                i--;
            }
        }
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
