package org.example;

public class Main {
    public static void main(String[] args) {
        //method(3);  //1. non recursion call
        System.out.println(factorial(5));
        System.out.println();
        System.out.println(factorialRecursion(5));
        int[] array = {1,2,3,4};
        System.out.println();
        System.out.println();
        System.out.println(binarySearch(array, 0));
        System.out.println(binarySearch(array, 2));
        System.out.println();
        System.out.println(recursionBinarySearch(array, 0));
        System.out.println(recursionBinarySearch(array, 2));

    }

    private static int recursionBinarySearch(int[] array, int i) {
        return recursionBinarySearchWork(array,i,0,array.length-1);
    }

    public static void method(int x){
        if(x > 5){
            return; //2. non recursion return
        }
        System.out.println(x);
        method(x+1);  //3. recursion return go to non recursion return
    }
    public static int factorial(int x){
        int res = 1;
        for(int i = 1; i<=x; i++){
            res *= i;
        }
        return res;
    }
    public static int recursionBinarySearchWork(int[] array, int x, int left, int right){
        if(left > right){
            return -1;
        }
        int middle = (left + right) / 2;
        if(array[middle]==x){
            return middle;
        }else if( x > array[middle]){
            left = middle +1;
        }else{
            right = middle -1;
        }
        return recursionBinarySearchWork(array, x, left, right);
    }
    public static int binarySearch(int[] array, int x){
        int left = 0;
        int right = array.length-1;
        int middle;
        while (left <= right){
            middle = (left + right) / 2;
            if(array[middle]==x){
                return middle;
            }else if( x > array[middle]){
                left = middle +1;
            }else{
                right = middle -1;
            }
        }
        return - 1;
    }

    public static int factorialRecursion(int x){
        return x == 0 ? 1 : x * factorialRecursion(x - 1);
    }
}