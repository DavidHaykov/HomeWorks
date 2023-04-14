package org.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class HashSetClass extends AbstractSet{

    public HashSetClass() {
        super(new HashSet<>());
    }

    @Override
    public void removeDividedBy(int number) {
        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return number%integer==0;
            }
        });
    }
}
