package org.example;

import java.util.function.Predicate;

public class EvenNumbersPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer %2==0;
    }
}
