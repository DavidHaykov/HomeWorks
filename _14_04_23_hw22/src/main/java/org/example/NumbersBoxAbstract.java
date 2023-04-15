package org.example;

import java.util.*;

public abstract class NumbersBoxAbstract implements INumbersBox {

    protected Collection<Integer> numbers;

    public NumbersBoxAbstract(Collection<Integer> numbers) {
        this.numbers = numbers;
    }

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
    public void removeRepeated() {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        numbers.clear();
        numbers.addAll(uniqueNumbers);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive) {
        numbers.removeIf(number -> number >= fromInclusive && number < toExclusive);
    }
}

