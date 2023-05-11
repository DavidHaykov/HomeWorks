package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
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
        ArrayList<Movie>  list = new ArrayList<>(Arrays.asList(array));

        Stream<Movie> s = Arrays.stream(array);
        Stream<Movie> s1 = list.stream();

        IntStream s2 = "Helloworld".chars();
        Stream<String> s3 = Stream.of("a", "b", "c", "d");
        Stream<Integer> s4 = Stream.<Integer>builder().add(1).add(2).add(3).build();

        IntStream.iterate(1, number -> number * 2).limit(10).forEach(System.out::println);
        Stream.generate(() -> "hello").limit(10).forEach(System.out::println);
        Stream.generate(() -> new Random().nextBoolean()).limit(10).forEach(System.out::println);

        s.forEach(System.out::println);
        //s.forEach(elem -> System.out.println(elem));


    }

}
