package org.example;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionIntro {
    public static void main(String[] args) {
        Function<String, Integer> fun = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println(fun.apply("Hello world!"));

        Function<String, String> fun1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        System.out.println(fun1.apply("Hello world!"));
        BiFunction<String, String, String> fun2 = new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        };
        System.out.println(fun2.apply("Hello", " world!"));

        TreeFunction<String, String, String, String> fun3 = new TreeFunction<String, String, String, String>() {
            @Override
            public String doSomething(String s, String s2, String s3) {
                return s + s2 + s3;
            }
        };
    }
}
