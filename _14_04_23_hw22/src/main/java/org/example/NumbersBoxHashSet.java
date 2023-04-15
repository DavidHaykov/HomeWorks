package org.example;

import java.util.HashSet;
import java.util.Set;

public class NumbersBoxHashSet extends NumbersBoxAbstract {

    public NumbersBoxHashSet() {
        super(new HashSet<>());
    }

    @Override
    public void removeDividedBy(int number) {
        Set<Integer> newNumbers = new HashSet<>();
        for (int n : numbers) {
            if (n % number != 0) {
                newNumbers.add(n);
            }
        }
        numbers.clear();
        numbers.addAll(newNumbers);
    }
}
