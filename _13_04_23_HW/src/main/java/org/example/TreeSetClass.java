package org.example;

import java.util.Collection;
import java.util.TreeSet;
import java.util.function.Predicate;

public class TreeSetClass extends AbstractSet{
    public TreeSetClass() {
        super(new TreeSet<>());
    }

    @Override
    public void removeDividedBy(int number) {
        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%number==0;
            }
        });
    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive) {
        TreeSet<Integer> set = new TreeSet<>(numbers);
        numbers.addAll(set.subSet(fromInclusive,toExclusive));
    }
}
