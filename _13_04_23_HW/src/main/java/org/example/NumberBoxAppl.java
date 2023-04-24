package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class NumberBoxAppl {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,55,6,55,7};
        List<Integer> arrayList = Arrays.asList(array);
        TreeSetClass tree = new TreeSetClass();
        tree.addNumber(1);
        tree.addNumber(2);
        tree.addNumber(3);
        tree.addNumber(4);
        tree.addNumber(5);
        tree.addNumber(6);
        tree.addNumber(7);
        tree.display();
        tree.removeInRange(2,7);
        tree.display();


    }
}
