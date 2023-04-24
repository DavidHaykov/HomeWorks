package org.example;

import java.util.Collection;
import java.util.function.Predicate;

public abstract class AbstractCollection implements INumbersBox {
    protected Collection<Integer> numbers;




    @Override
    public void addNumber(int number) {
        numbers.add(number);
    }

    @Override
    public void removeNumber(int number) {
        numbers.remove(number);
    }

    @Override
    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public abstract void removeRepeated();

    @Override
    public  void removeDividedBy(int number){
        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%number==0;
            }
        });
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public void removeInRange(int fromInclusive, int toExclusive){
        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer>= fromInclusive && integer < toExclusive;
            }
        });
    }
}
