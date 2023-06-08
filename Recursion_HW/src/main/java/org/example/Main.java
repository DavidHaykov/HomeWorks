package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        printArray(arr);
        System.out.println(sumArray(arr));
        print100Numbers(55);
        System.out.println(pow(2,3));
    }
    private static double pow(double x, int n){
        double temp = x;
       if(n == 0){
           return 0;
       }
       temp *= x;
       return n == 1 ? x : pow(temp, n-1);
    }

    private static void print100Numbers(int i){
        if(i <= 100){
            System.out.println(i);
            print100Numbers(i+1);
        }
    }
    private static long sumArray(int[] arr){
        return sumArrayRecursive(arr, 0);

    }
    private static int sumArrayRecursive(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        int currentNumber = arr[index];
        int remainingSum = sumArrayRecursive(arr, index + 1);
        return currentNumber + remainingSum;
    }

    private static void reverseArray(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        reverseArray(array, start + 1, end - 1);
    }

    private static void printArray(int[] arr){
        if(arr.length==0){
            return;
        }
        System.out.println(arr[arr.length-1]);
        printArray(Arrays.copyOf(arr, arr.length-1));
    }
}
