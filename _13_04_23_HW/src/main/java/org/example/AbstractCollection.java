package org.example;

import java.util.Collection;
import java.util.function.Predicate;

public abstract class AbstractCollection implements INumbersBox {
    protected Collection<Integer> numbers;




    @Override
    public void addNumber(int number) {
        numbers.add(number);
    }

    @Override
    public void removeNumber(int number) {
        numbers.remove(number);
    }

    @Override
    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public abstract void removeRepeated();

    @Override
    public abstract void removeDividedBy(int number);

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public abstract void removeInRange(int fromInclusive, int toExclusive);
}
