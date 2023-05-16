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

        double av =
                Arrays.stream(array)
                        .mapToDouble(m -> m.rating)
                        .average()
                        .getAsDouble();
        System.out.println(av);

        List<Integer> randomList = new Random()
                .ints(10, 0, 100)
                .boxed()
                .toList();

        System.out.println(randomList);

        DoubleSummaryStatistics stat =
                Arrays.stream(array)
                        .mapToDouble(m -> m.rating)
                        .summaryStatistics();
        System.out.println(stat);

        long count = stat.getCount();
        System.out.println(count);

        System.out.println(Arrays.stream(array)
                .mapToDouble(m -> m.rating)
                .distinct()
                .count());

        System.out.println(array.length);

        Stream.of("Mamam mila ramu")
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .forEach(System.out::println);

        String[] words = Stream.of("Mamam mila ramu")
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .sorted((w1, w2) -> w2.compareTo(w1)).toArray(String[]::new);

        System.out.println(Arrays.toString(words));

        Stream.of(2, 3, 0, 1)
                .flatMapToInt(n -> IntStream.rangeClosed(0, n))
                .forEach(System.out::print);
        System.out.println("\n");

        List<List<String>> list = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("a", "b", "c")),
                new ArrayList<>(Arrays.asList("d", "e", "e", "a"))
        ));
        list.stream()
                .flatMap(l -> l.stream())
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n");

        Stream.of("hello", "world")
                .flatMap(s -> s.chars()
                        .mapToObj(i -> (char) i))
                .forEach(System.out::println);

        System.out.println("\n");

        Stream.of("hello", "world").
                mapMulti((s, sink) -> {
                    for (char c : s.toCharArray()) {
                        sink.accept(c);
                    }
                })
                .forEach(System.out::println);

        int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, (id, number) -> id + number);
        System.out.println(sum);

        ArrayList<Integer> list1 = new ArrayList<>();
        sum = list1.stream()
                .reduce(2, (id, n) -> id + n);
        System.out.println(sum);

        sum = list1.stream()
                .reduce((id, n) -> id + n)
                .orElse(0);
        System.out.println(sum);

        int[] nums = {1,2,3,4};

        Arrays.stream(nums)
                .forEach(System.out::println);

        System.out.println();

        Arrays.stream(nums)
                .parallel()
                .forEach(System.out::println);


    }



}
