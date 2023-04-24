package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

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
    }
    private static void fillMap(Map<String, Integer> month){
        month.put("Jan", 1);
        month.put("Feb", 2);
        month.put("Mar", 3);
        month.put("Apr", 4);
    }
}
