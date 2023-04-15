package org.example;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public abstract class AbstractList extends AbstractCollection {
    public AbstractList(Collection<Integer> numbers) {
        super(numbers);
    }
    @Override
    public void removeRepeated() {
        Set<Integer> notRepeat = new HashSet<>(numbers);
        numbers.clear();
        numbers.addAll(notRepeat);
    }

}


