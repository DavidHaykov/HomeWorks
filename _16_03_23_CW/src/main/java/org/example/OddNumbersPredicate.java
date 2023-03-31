package org.example;

import java.util.function.Predicate;

public class OddNumbersPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        return integer%2!=0;
    }
}
