package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter .api.Assertions.*;

import java.util.*;

class ListTest {
    Integer[] array = {1,2,3,4,4,4,1,20};
    List<Integer> list;



    @BeforeEach
    void setUp() {
        list = new ArrayList<>(Arrays.asList(array));


    }

    @Test
    void testRemoveNumber() {
        list.remove(2);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove((Integer) 2);
        System.out.println(Arrays.toString(list.toArray()));
        ((Collection<Integer>) list).remove(20);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("********************");
    }

    @Test
    void testRemoveAll() {
        list.removeAll(Arrays.asList(4,1));
        System.out.println(Arrays.toString(list.toArray()));
        assertFalse(list.contains(4));
        assertFalse(list.contains(1));
        System.out.println("********************");

    }

    @Test
    void testRetainAll(){
        list.retainAll(Arrays.asList(4,1));
        System.out.println(Arrays.toString(list.toArray()));
        assertTrue(list.contains(4));
        assertTrue(list.contains(1));
        assertFalse(list.contains(20));
        System.out.println("********************");
    }

    @Test
    void testNotSupported(){
        List<Integer> temp = Arrays.asList(1,2,3);
        assertEquals(3,temp.size());
        assertTrue(temp.contains(1));
        assertEquals(temp.get(0), 1);
        //temp.add(20);
    }

    @Test
    void testSubList() {
        List <Integer> temp = list.subList(1,4);
        System.out.println(Arrays.toString(temp.toArray()));
        temp.remove((Integer) 3);
        System.out.println(Arrays.toString(temp.toArray()));
        System.out.println(Arrays.toString(list.toArray()));
        assertFalse(list.contains(3));
        System.out.println("********************");
    }

    @Test
    void testAdd() {
        assertTrue(list.add(100));
        System.out.println(Arrays.toString(list.toArray()));
        assertEquals(100, list.get(8));
        System.out.println("********************");
    }

    @Test
    void testClear(){
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testToArray() {
        Object[] temp = list.toArray();
        assertArrayEquals(temp, array);
        Integer[] temp1 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(Arrays.stream(temp1).toArray()));
        System.out.println("********************");
    }


}