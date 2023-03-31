package org.example;

import java.util.function.Predicate;

public class ThreeNumbersPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer%3==0;
    }
}
