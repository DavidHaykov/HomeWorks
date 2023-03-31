package org.example;


import java.util.Arrays;

public class ArrayUtils
{
    //	The method takes an array and returns an array with element added to the end
    public static int[] add(int[] array, int num)
    {
        int[] res = new int[array.length+1];
        for(int i = 0; i< res.length; i++){
            if(i< array.length){
                res[i] = array[i];
            }
            if(i== array.length){
                res[i] = num;
            }
        }
        return res;
    }

    //	The method takes an array and returns an array without the last element
    public static int[] remove(int[] ar)
    {
        int[] res = new int[ar.length-1];
        System.arraycopy(ar, 0, res, 0, res.length);
        return res;
    }

    //	The method accepts an array, and returns an array without an element at the passed index
    public static int[] remove(int[] ar, int index)
    {
        int[]res = new int[ar.length-1];
        for(int i = 0;i<ar.length;i++){
            if(i<index){
                res[i]= ar[i];
            }
            if(i == index){
               continue;
            }
            if(i>index){
                res[i-1]=ar[i];
            }
    }
        return res;
    }

    //	The method returns the sum of all matrix elements
    public static long marixSum(int[][] matrix)
    {
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    //	***
    public static int[][] addColumn(int[][] matrix, int index, int[] columnElements)
    {
        int[][] res = new int[matrix.length+1][];
        for(int i =0; i<res.length;i++){
            if(i<index){
                res[i]=matrix[i];
            }
            if(i==index){
                   res[i]=columnElements;

            }
            if(i>index){
                res[i]=matrix[i-1];
            }
        }
        return res;
    }

    public static int[][] removeRow(int[][] matrix, int index)
    {
        int[][] res = new int[matrix.length][matrix[0].length-1];
        for(int i = 0; i<res.length; i ++){
            for(int j = 0; j< res[i].length; j++){
                if(j<index){
                    res[i][j]=matrix[i][j];
                }
                if(j>=index){
                    res[i][j] = matrix[i][j+1];
                }
            }
        }
        return res;
    }

    public static int[][] removeColumn(int[][] matrix, int index)
    {
        int[][] res = new int[matrix.length-1][];
        for(int i = 0; i<res.length; i++){
            if(i<index){
                res[i] = matrix[i];
            }

            if(i>=index){
                res[i]=matrix[i+1];
            }
        }
        return res;
    }


}