package org.example;

import org.example.myArray.MyArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {
    MyArray<Integer> numbers;
    MyArray<String> strings;
    MyArray<String> strings1;
    Integer[] arNumbers = {10,7,11,-2,13,10,2000};
    String[] arStrings = {"abc", "lmn", "qwerty", "abc"};
    String[] arStrings1 = {"cdf", "bastard"};


    @BeforeEach
    void setUp() throws Exception{
        numbers = new MyArray<Integer>();
        for (Integer arNumber : arNumbers) {
            numbers.add(arNumber);
        }
        strings = new MyArray<String>(1);
        for (String arString : arStrings) {
            strings.add(arString);
        }
        strings1 = new MyArray<>();
        for (String s : arStrings1) {
            strings1.add(s);
        }

    }

    @Test
    void testIterator(){
        int index = 0;
        for (Integer num : numbers) {
            assertEquals(arNumbers[index++], num);
        }
    }

    @Test
    void testRemoveIf(){
        strings.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>3;
            }
        });
        System.out.println(Arrays.toString(strings.toArray()));
    }
    @Test
    void indexOfPredicate(){
        System.out.println(strings.indexOf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>3;
            }
        }));

    }
    @Test
    void lastIndexOfPredicate(){
        System.out.println(numbers.lastIndexOf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer>10;
            }
        }));
    }
    @Test
    void  testSort(){
        Integer[] expected = {2000,13,11,10,10,7,-2};
        numbers.sort(new ReverseNumberComporator());
        System.out.println(Arrays.toString(numbers.toArray()));
        strings.sort(new SimpleStringComporator());
        System.out.println(Arrays.toString(strings.toArray()));
        strings.sort(new LengthStringComparator());
        System.out.println(Arrays.toString(strings.toArray()));
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toString().length() - o2.toString().length();
            }
        });
        System.out.println(Arrays.toString(strings.toArray()));
    }
    @Test
    void testAddAll2(){
        strings.addAll(strings1, 2);
    }
    @Test
    void testRemoveAll(){
        String[] expected = {"lmn", "qwerty"};
        assertTrue(strings.removeAll("abc"));
        assertFalse(strings.removeAll("tgs"));
        assertFalse(strings.removeAll("abcdf"));


    }

    @Test
    void testAddAll(){
        System.out.println(Arrays.toString(strings.toArray()));
        String[] expected = {"abc", "lmn", "qwerty", "abc", "cdf", "bastard"};
        strings.addAll(strings1);


    }


    @Test
    void testSet(){
        Integer[] expected = {10,2,11,-2,13,10,2000};
        assertTrue(numbers.set(2,1));
        assertArrayEquals(expected, numbers.toArray());


    }
    @Test
    void testAddGetSize() {
        int sizeNumbers = numbers.size();
        int sizeStrings = strings.size();
        assertEquals(arNumbers.length, sizeNumbers);
        assertEquals(arStrings.length, sizeStrings);
        for(int i = 0; i< sizeNumbers; i++){
            assertEquals(numbers.get(i), arNumbers[i]);
        }
        for(int i = 0; i< sizeStrings; i++){
            assertEquals(strings.get(i), arStrings[i]);
        }

    }


    @Test
    void indexOf() {
        assertEquals(0,numbers.indexOf(10));
        assertEquals(6,numbers.indexOf(2000));
        assertEquals(-1,numbers.indexOf(100));
        assertEquals(0,strings.indexOf("abc"));
        assertEquals(-1,strings.indexOf("abcd"));
    }

    @Test
    void lastIndexOf() {
        assertEquals(5,numbers.lastIndexOf(10));
        assertEquals(6,numbers.lastIndexOf(2000));
        assertEquals(-1,numbers.lastIndexOf(100));
        assertEquals(3,strings.lastIndexOf("abc"));
        assertEquals(-1,strings.lastIndexOf("abcd"));

    }

    @Test
    void testRemoveAtIndex(){
        Integer[] actual = {10,7,-2,13,10,2000}; //remove index 2
        Integer[] expected = {10,-2,13,10,2000};
        assertNull(numbers.remove(100));
        assertEquals(11,numbers.remove(2));

        assertEquals(numbers.size(), actual.length);
        for(int i = 0; i< actual.length; i++){
            assertEquals(numbers.get(i), actual[i]);
        }

    }

    @Test
    void testRemoveObject() {
        Integer[] actual = {10,7,-2,13,10,2000};  //remove object 11;
        assertTrue(numbers.remove((Integer)11));
        assertEquals(numbers.size(), actual.length);
        for(int i = 0; i< actual.length; i++){
            assertEquals(numbers.get(i), actual[i]);
        }
    }

    @Test
    void contains() {
        assertTrue(numbers.contains(10));
        assertTrue(numbers.contains(13));
        assertTrue(numbers.contains(-2));
        assertFalse(numbers.contains(111));
        assertFalse(numbers.contains(20001));
    }
    @Test
    void addIndex(){
        assertTrue(numbers.add(1,2));


    }

    @Test
    void toArray() {
        Integer[] expected = {10,7,11,-2,13,10,2000};
        String[] expected1 = {"abc", "lmn", "qwerty", "abc"};

        assertArrayEquals(expected, numbers.toArray());
        assertArrayEquals(expected1, strings.toArray());

    }
}