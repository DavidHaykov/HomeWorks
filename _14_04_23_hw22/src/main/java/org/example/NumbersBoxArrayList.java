package org.example;

import java.util.ArrayList;

public class NumbersBoxArrayList extends NumbersBoxAbstract {

    public NumbersBoxArrayList() {
        super(new ArrayList<>());
    }

    @Override
    public void removeDividedBy(int number) {
        numbers.removeIf(n -> n % number == 0);
    }
}
