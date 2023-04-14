package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractSet extends AbstractCollection {
    public AbstractSet(Collection<Integer> numbers) {
        super(numbers);
    }


    @Override
    public void removeRepeated() {

    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive) {
        List<Integer> list = new ArrayList<>(numbers);
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= fromInclusive && integer < toExclusive;
            }
        });
        numbers.clear();
        numbers.addAll(list);

    }
}
