package org.example;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapAdvanced {
    public static void main(String[] args) {
        Map<String, Integer> month = new HashMap<>();
        fillMap(month);
        month.replaceAll(new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
                return integer*10;
            }
        });
        System.out.println(month);

        month.compute("Dec", new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
                return integer==null? 100 : integer + 1;
            }
        });
        System.out.println(month);

        month.computeIfAbsent("Jun", new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                int res = Integer.MAX_VALUE;
                res -= 150;
                return res;
            }
        });
        System.out.println(month);

        month.computeIfPresent("Jan", new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String s, Integer integer) {
                return integer*10;
            }
        });
        System.out.println(month);

        System.out.println(reverseMap(month));

        month.merge("Jan", 1, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        });
        System.out.println(month);

        month.merge("Oct", 1, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        });
        System.out.println(month);
        month.merge("Oct", 1, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return null;
            }
        });
        System.out.println(month);
    }
    private static Map<Integer, List<String>> reverseMap(Map<String, Integer> map){
        Map<Integer, List<String>> res= new HashMap<>();
        for(String str : map.keySet()){
            Integer value = map.get(str);
            res.compute(value, new BiFunction<Integer, List<String>, List<String>>() {
                @Override
                public List<String> apply(Integer integer, List<String> strings) {
                    if(strings == null ){
                        strings = new ArrayList<>();
                    }
                    strings.add(str);
                    return strings;
                }
            });
        }
        return res;
    }

    private static void fillMap(Map<String, Integer> month){
        month.put("Jan", 1);
        month.put("Feb", 2);
        month.put("Mar", 3);
        month.put("Apr", 4);
    }
}
