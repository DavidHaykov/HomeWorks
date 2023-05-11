package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class MovieAppl {
    public static void main(String[] args) {
        Movie[] array = {
               new Movie("A", 2022, 4),
               new Movie("B", 2023, 4.5),
               new Movie("C", 2022, 4.5),
               new Movie("D", 2023, 3.5),
               new Movie("E", 2023, 5.5),
               new Movie("AA", 2023, 5.5),
               new Movie("AA", 2023, 5.5),
        };
        displayMoviesTittleStream(array, 2023, 4);
        Stream.of(1,2,3,4,5,6,7,8,9,1,2,3,4,5)
                .takeWhile(n -> n < 6)
                .forEach(System.out::println);
        Stream.of(1,2,3,4,5,6,7,8,9,1,2,3,4,5)
                .dropWhile(n -> n < 6)
                .forEach(System.out::println);

    }
    private static void displayMoviesTittleStream(Movie[] array, int year, double rating){
        Arrays.stream(array)
                .filter(m -> m.year == year && m.rating>= rating)
                .peek(t -> System.out.println(t))
                .sorted((m1, m2) -> {
                    int res = Double.compare(m1.rating, m2.rating);
                    return res == 0? m1.title.compareTo(m2.title) : res;
                })
                .map(m -> m.title)
                .forEach(System.out::println);
        Arrays.stream(array)
                .distinct()
                .skip(2)
                .limit(3)
                .forEach(System.out::println);

    }

    private static void displayMoviesTitle(Movie[] array, int year, double rating) {
        ArrayList<Movie> list = new ArrayList<>();
        for(Movie m : array){
            if(m.year == year && m.rating >= rating){
                list.add(m);
            }
        }
        list.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                int res = Double.compare(o1.rating, o2.rating);
                return res == 0? o1.title.compareTo(o2.title) : res;
            }
        });
        for(Movie m : list){
            System.out.println(m.title);
        }
    }
}