package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        Movie[] array = {
                new Movie("A", 2022, 4),
                new Movie("B", 2023, 4.5),
                new Movie("C", 2022, 4.5),
                new Movie("D", 2023, 3.5),
                new Movie("E", 2023, 5.5),
                new Movie("AA", 2023, 5.5),
        };
        System.out.println(Arrays.stream(array).allMatch(m -> m.year > 2000));
        System.out.println(Arrays.stream(array).allMatch(m -> m.year > 2022));
        System.out.println(Arrays.stream(array).anyMatch(m -> m.year == 2022));
        System.out.println(Arrays.stream(array).noneMatch(m -> m.year == 2000));
        System.out.println(Arrays.stream(array).distinct().findFirst().get());



    }



}
