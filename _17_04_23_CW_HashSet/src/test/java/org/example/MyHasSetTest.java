package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyHasSetTest {
    MyHasSet<Integer> hs;
    Integer[] arr = {2,3,4,5,6};
    ArrayList<Integer> actual = new ArrayList<>(List.of(arr));


    @BeforeEach
    void setUp() throws Exception{
        hs = new MyHasSet<>();
        for(Integer num : actual){
            hs.add(num);
        }
    }

    @Test
    void contains() {
        for(Integer num : actual){
            assertTrue(hs.contains(num));
        }
        assertFalse(hs.contains(1));
    }

    @Test
    void toArray() {
        Object[] res =  hs.toArray();
        assertEquals(res.length, actual.size());
        for(Object num : res){
            assertTrue(actual.contains(num));
        }
    }

    @Test
    void add() {
        assertEquals(hs.size(), actual.size());
        assertFalse(hs.add(2));
        assertTrue(hs.add(1));
        assertEquals(hs.size, actual.size()+1);
    }

    @Test
    void remove() {
        assertFalse(hs.remove(9));
        assertEquals(hs.size(), actual.size());
        assertTrue(hs.remove(5));
        assertEquals(hs.size(), actual.size()-1);
        assertFalse(hs.contains(5));
    }
    @Test
    public void testClear() {
        MyHasSet<Integer> set = new MyHasSet<>();
        set.add(1);
        set.add(2);
        set.clear();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
        assertFalse(set.contains(1));
        assertFalse(set.contains(2));
    }

    @Test
    public void testIsEmpty() {
        MyHasSet<Integer> set = new MyHasSet<>();
        assertTrue(set.isEmpty());
        set.add(1);
        assertFalse(set.isEmpty());
        set.remove(1);
        assertTrue(set.isEmpty());
    }

    @Test
    public void testAddAll() {
        MyHasSet<Integer> set = new MyHasSet<>();
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertTrue(set.addAll(list));
        assertTrue(set.containsAll(list));
        assertFalse(set.addAll(list));
    }

    @Test
    public void testRemoveAll() {
        MyHasSet<Integer> set = new MyHasSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        List<Integer> list = Arrays.asList(2, 3, 4);
        assertTrue(set.removeAll(list));
        assertEquals(1, set.size());
        assertTrue(set.contains(1));
        assertFalse(set.contains(2));
        assertFalse(set.contains(3));
    }

    @Test
    public void testContainsAll() {
        MyHasSet<Integer> set = new MyHasSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        List<Integer> list = Arrays.asList(2, 3);
        assertTrue(set.containsAll(list));
        list = Arrays.asList(2, 3, 4);
        assertFalse(set.containsAll(list));
    }
}