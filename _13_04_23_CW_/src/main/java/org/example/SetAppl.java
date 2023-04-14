package org.example;

import java.util.*;

public class SetAppl {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10,20);
        Rectangle r2 = new Rectangle(20,10);

        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());

        Rectangle r3 = new Rectangle(1,1);
        Rectangle r4 = new Rectangle(0,32);

        System.out.println(r3.hashCode());
        System.out.println(r4.hashCode());

        Rectangle r5 = new Rectangle(20,10);
        Set<Rectangle> set = new HashSet<>(Arrays.asList(r1,r2,r3,r4,r5));
        System.out.println(set);

        for (Rectangle r: set) {
            System.out.println(r);
        }
        r1.x = 100;
        set.remove(r1);
        System.out.println(set);

        TreeSet<Rectangle> set1 = new TreeSet<>(Arrays.asList(r1,r2,r3,r4,r5));
        System.out.println(set1);
    }
}
