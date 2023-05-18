package org.example;

import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
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

        String[] strArray = {"Java","Java", "Pojo", "Java Script", "C++", "Kotlin"};


//        List<Movie> list = Arrays.stream(array)
//                .distinct()
//                .collect(Collectors.toList());
        List<Movie> list = Arrays.stream(array)
                .distinct().toList();

        Set<Movie> set = Arrays.stream(array)
                .skip(1)
                .collect(Collectors.toSet());

        System.out.println(list);
        System.out.println(set);

        Map<String, Double> map = Arrays.stream(array)
                .distinct()
                .collect(Collectors.toMap(movie -> movie.title, movie -> movie.rating));
        Map<String, Integer> strMap = Arrays.stream(strArray)
                .distinct()
                //.collect(Collectors.toMap(s -> s, String::length));    ======= OPTION
                .collect(Collectors.toMap(Function.identity(), String::length));    // ======= OPTION

        System.out.println(strMap);

        LinkedList<Movie> ll = Arrays.stream(array)
                .collect(Collectors.toCollection(LinkedList::new));     //() -> new LinkedList<>();
        LinkedHashSet<Movie> ts = Arrays.stream(array)
                .collect(Collectors.toCollection(LinkedHashSet::new));        //() -> new TreeSet<>();
        System.out.println(ts);

        Map<Double, List<Movie>> mapRating = Arrays.stream(array)
                .collect(Collectors.groupingBy(m -> m.rating));
        mapRating.entrySet().forEach(System.out::println);

        Map<Integer, Long> countYear = Arrays.stream(array)
                .collect(Collectors.groupingBy(movie -> movie.year, Collectors.counting()));
        countYear.entrySet().forEach(System.out::println);

        System.out.println();
        Map<Integer, Map<Character, List<String>>> map1 = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(s -> s.charAt(0))));
        map1.entrySet().forEach(System.out::println);

        System.out.println();
        Map<Integer, Map<Character, Long>> map2 = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(s -> s.charAt(0), Collectors.counting())));
        map2.entrySet().forEach(System.out::println);

        System.out.println();
        Map<Boolean, List<Movie>> map3 = Arrays.stream(array)
                .collect(Collectors.partitioningBy(m -> m.rating > 4));
        map3.entrySet().forEach(System.out::println);

        System.out.println();
        Map<Boolean, Double> map4 = Arrays.stream(array)
                .collect(Collectors.partitioningBy(m -> m.rating > 4, Collectors.averagingDouble(m -> m.rating)));
        map4.entrySet().forEach(System.out::println);

        System.out.println("\n" + Arrays.stream(strArray).collect(Collectors.joining()));
        System.out.println("\n" + Arrays.stream(strArray).collect(Collectors.joining("*-*")));
        System.out.println("\n" + Arrays.stream(strArray).collect(Collectors.joining("*-*", "Start: ", " End")));

        System.out.println();
        Map<Integer, String> map5 = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(String::length, Collectors.joining(" ")));
        map5.entrySet().forEach(System.out::println);



    }



}
