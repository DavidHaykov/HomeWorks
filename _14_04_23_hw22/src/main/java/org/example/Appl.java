package org.example;

import java.util.Arrays;

public class Appl {
    public static void main(String[] args) {
        NumbersBoxLinkedList linkedList = new NumbersBoxLinkedList();
        linkedList.addNumber(1);
        linkedList.addNumber(2);
        linkedList.addNumber(3);
        linkedList.addNumber(4);
        linkedList.addNumber(5);
        linkedList.addNumber(5);
        linkedList.addNumber(5);
        linkedList.addNumber(5);

        NumbersBoxArrayList arrayList = new NumbersBoxArrayList();
        arrayList.addNumber(1);
        arrayList.addNumber(2);
        arrayList.addNumber(3);
        arrayList.addNumber(4);
        arrayList.addNumber(5);
        arrayList.addNumber(5);
        arrayList.addNumber(5);
        arrayList.addNumber(5);

        NumbersBoxHashSet hashSet = new NumbersBoxHashSet();
        hashSet.addNumber(1);
        hashSet.addNumber(2);
        hashSet.addNumber(3);
        hashSet.addNumber(4);
        hashSet.addNumber(5);
        hashSet.addNumber(5);
        hashSet.addNumber(5);
        hashSet.addNumber(5);

        NumbersBoxTreeSet treeSet = new NumbersBoxTreeSet();
        hashSet.addNumber(1);
        hashSet.addNumber(2);
        hashSet.addNumber(3);
        hashSet.addNumber(4);
        hashSet.addNumber(5);
        hashSet.addNumber(5);
        hashSet.addNumber(5);
        hashSet.addNumber(5);


        hashSet.removeDividedBy(2);
        System.out.println(Arrays.toString(hashSet.numbers.toArray()));
        System.out.println(Arrays.toString(treeSet.numbers.toArray()));
        arrayList.removeRepeated();
        linkedList.removeRepeated();
        System.out.println(Arrays.toString(arrayList.numbers.toArray()));
        System.out.println(Arrays.toString(linkedList.numbers.toArray()));
    }





}
