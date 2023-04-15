package org.example;

import java.util.Set;
import java.util.TreeSet;

public class NumbersBoxTreeSet extends NumbersBoxAbstract {

    public NumbersBoxTreeSet() {
        super(new TreeSet<>());
    }

    @Override
    public void removeDividedBy(int number) {
        Set<Integer> newNumbers = new TreeSet<>();
        for (int n : numbers) {
            if (n % number != 0) {
                newNumbers.add(n);
            }
        }
        numbers.clear();
        numbers.addAll(newNumbers);
    }
}
