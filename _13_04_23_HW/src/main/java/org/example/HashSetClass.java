package org.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class HashSetClass extends AbstractSet{
    private HashSet<Integer> numbers;
    public HashSetClass(Collection<Integer> numbers) {

        this.numbers = new HashSet<>(numbers);
    }


    @Override
    public void removeRepeated() {

    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive) {
        Set<Integer> toRemove = new HashSet<>();
        for (int num : numbers) {
            if (num >= fromInclusive && num < toExclusive) {
                toRemove.add(num);
            }
        }
        numbers.removeAll(toRemove);
    }
}
