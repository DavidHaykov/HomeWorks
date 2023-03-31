package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListPerformanceTest {
    private List<Integer> list;
    private int size;
    private int nRuns;
    private String listType;

    public ListPerformanceTest(List<Integer> list, int size, int nRuns, String listType) {
        this.list = list;
        this.size = size;
        this.nRuns = nRuns;
        this.listType = listType;
        setUp();

    }

    public int getSize() {
        return size;
    }

    private void setUp() {
        for(int i = 1; i <= size; i++){
            list.add(i);
        }

    }
    public void runAllTest() {
        addRemoveTest();
        containsTest();
        subListTest();
        getAtIndexTest();
        iteratotTest();

    }

    public void getAtIndexTest(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i< nRuns; i++){
            Random rand = new Random();
            int min = 1;
            int max = size;
            int add = size + 1;
            int range = max - min + 1;
            int randomInt = rand.nextInt(range) + min-1;
            list.get(randomInt);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Method getAtIndex running time = " + duration +" " +  listType);
    }

    public void iteratotTest(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<nRuns; i++){
            for(int j = 0; j < size; j++){
                int temp = j;
            }
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Method iterator running time = " + duration +" " +  listType);
    }
    public void addRemoveTest(){

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < nRuns; i++) {
            Random rand = new Random();
            int min = 1;
            int max = size;
            int add = size + 1;
            int range = max - min + 1;
            int randomInt = rand.nextInt(range) + min;

            list.add(randomInt, add);
            list.remove(randomInt);
        }


        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Method add/remove running time = " + duration +" " +  listType);

    }
    public void containsTest(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<nRuns; i++) {
            Random rand = new Random();
            int min = 1;
            int max = size;
            int range = max - min + 1;
            int randomInt = rand.nextInt(range) + min-1;
            list.contains(list.get(randomInt));

        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Method contains running time = " + duration + " " + listType);
    }

    public void subListTest(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i< nRuns; i++) {
            Random rand = new Random();
            int min = 1;
            int max = size;
            int range = max - min + 1;
            int randomInt = rand.nextInt(range) + min;
            int randomInt1 = rand.nextInt(range) + min;
            int left = Math.min(randomInt, randomInt1);
            int right = Math.max(randomInt1, randomInt);

            list.subList(left, right);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Method sublist running time = " + duration +" " +  listType);

    }

}
