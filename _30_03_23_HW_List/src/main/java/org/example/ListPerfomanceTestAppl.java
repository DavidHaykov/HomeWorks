package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerfomanceTestAppl {
    public static final int SIZE = 1000;
    public static final int N_RUNS = 1000000;
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListPerformanceTest array = new ListPerformanceTest(arrayList, SIZE, N_RUNS, "ArrayList");
        ListPerformanceTest linked = new ListPerformanceTest(linkedList, SIZE, N_RUNS, "LinkedList");
        array.runAllTest();
        linked.runAllTest();

    }
}
