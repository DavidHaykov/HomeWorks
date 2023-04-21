package org.example;

import java.util.*;
import java.util.function.Predicate;

public class MapIntro {
    public static void main(String[] args) {
        Map<String, Integer> month = new LinkedHashMap<>();
        fillMap(month);
        System.out.println(month);
        System.out.println(month.put("May", 5));
        System.out.println(month);
        System.out.println(month.put("May", 15));
        System.out.println(month);
        Map<String, Integer> temp = new HashMap<>();
        fillMap(temp);
        temp.put("May", 100);
        temp.put("June", 6);
        month.putAll(temp);
        System.out.println(month.putIfAbsent("Jul", 7));
        System.out.println(month.putIfAbsent("Apr", 7));
        System.out.println(month);
        System.out.println(month.containsKey("Jan"));
        System.out.println(month.containsKey("Dec"));
        System.out.println(month.containsValue(1));
        System.out.println(month.containsValue(12));
        System.out.println(month.get("Jan"));
        System.out.println(month.get("Dec"));
        System.out.println(month.getOrDefault("Jan", 0));
        System.out.println(month.getOrDefault("Dec", 0));
        System.out.println(month.isEmpty());
        month.clear();
        System.out.println(month.isEmpty());
        fillMap(month);
        System.out.println("\n");
        iteratingKeys(month);
        iteratingValues(month);
        iteratingEntries(month);
        Map<Integer, Integer> randomNumbers = getRandomNumbers(0,10,100);
        System.out.println(randomNumbers);

        month.values().removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 != 0;
            }
        });
    }

    private static Map<Integer, Integer> getRandomNumbers(int min, int max, int count) {
        TreeMap<Integer, Integer> temp = new TreeMap<>();
        for(int i = 0; i< count; i++){
            int number = (int)((Math.random()*(max-min+1)+min));
//            Integer value = temp.get(number);
//            Integer newValue = value == null ? 1 : ++value;
//            temp.put(number, newValue);
            int value = temp.getOrDefault(number, 0);
            temp.put(number, value+1);
        }
        return temp;
    }

    private static void iteratingEntries(Map<String, Integer> month) {
        System.out.println("Iterating entries");
        for(Map.Entry<String, Integer> e : month.entrySet()){
            System.out.println(e);
        }
        System.out.println("\n");
    }

    private static void iteratingValues(Map<String, Integer> month) {
        System.out.println("Iterating values");
        for(Integer value : month.values()){
            System.out.println(value);
        }
        System.out.println("\n");
    }

    private static void iteratingKeys(Map<String, Integer> month) {
        System.out.println("Iterating keys");
        for (String key: month.keySet()) {
            System.out.println(key);
        }
        System.out.println("\n");
    }

    private static void fillMap(Map<String, Integer> month){
        month.put("Jan", 1);
        month.put("Feb", 2);
        month.put("Mar", 3);
        month.put("Apr", 4);
    }
}
