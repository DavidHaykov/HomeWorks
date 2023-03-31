package org.example;

import java.util.function.Predicate;

public class RangePredicate implements Predicate<Integer> {
    Integer min;
    Integer max;

    public RangePredicate(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean test(Integer integer) {
        return integer>= min && integer<=max;
    }
}
