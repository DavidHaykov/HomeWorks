package org.example;

import java.util.Arrays;

public class ComparatorAppl {
    public static void main(String[] args) {
        Product p = new Product("a", 1.1);
        Product p1 = new Product("a",10.1);
        Product p2 = new Product("b",1.1);
        Product[] arrray = {p,p1,p2};
        Arrays.sort(arrray);
        System.out.println(Arrays.toString(arrray));
        Arrays.sort(arrray, new  PriceComparator());
        System.out.println(Arrays.toString(arrray));
    }
}
