package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class CatAppl {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Bastard", "a", 1, 10);
        Cat cat2 = new Cat("CrazyCat", "b", 2, 12);
        Cat cat3 = new Cat("CrazyCat", "b", 3, 10);
        Cat cat4 = new Cat("Udot", "a", 3, 12);
        Cat cat5 = new Cat("Ryzhee chmo", "b", 5, 12);

        Cat[] array = {
                cat1,
                cat2,
                cat3,
                cat4,
                cat5
        };
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new NameComparator());
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new BreedComparator());
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new WeightAgeComparator());
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new WeigthComporator().reversed().thenComparing(new AgeComporator()));
        System.out.println(Arrays.toString(array));

        Cat[] catsNull = {
                cat1,
                null,
                cat2,
                cat3,
                null,
                cat4,
                cat5,
                null
        };
        Arrays.sort(catsNull, Comparator.nullsFirst(new AgeComporator()));
        System.out.println(Arrays.toString(catsNull));
    }
}
