package org.example;

import java.util.Collection;
import java.util.function.Predicate;

public abstract class AbstractList extends AbstractCollection {
    public AbstractList(Collection<Integer> numbers) {
        super(numbers);
    }
    public void removeDividedBy(int number) {
        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%number==0;
            }
        });
    }
}


