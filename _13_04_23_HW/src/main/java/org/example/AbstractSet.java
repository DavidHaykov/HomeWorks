package org.example;

import java.util.*;
import java.util.function.Predicate;

public abstract class AbstractSet extends AbstractCollection {




    public void removeDividedBy(int number) {
        Set<Integer> toRemove = new HashSet<>();
        for (int num : numbers) {
            if (num % number == 0) {
                toRemove.add(num);
            }
        }
        numbers.removeAll(toRemove);
    }


}

