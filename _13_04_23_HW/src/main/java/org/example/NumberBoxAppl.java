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
        TreeSetClass tree = new TreeSetClass(arrayList);
        tree.display();
        tree.removeInRange(2,7);
        tree.display();


    }
}
