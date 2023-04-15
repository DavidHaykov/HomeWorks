package org.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Predicate;

public class NumbersBoxLinkedList extends NumbersBoxAbstract {

    public NumbersBoxLinkedList() {
        super(new LinkedList<>());
    }

    @Override
    public void removeDividedBy(int number) {
        numbers.removeIf(n -> n % number == 0);
    }
}