package org.example;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        test(new int[0]);
        testVarArg(1);
        testVarArg(new int[]{1,2,3,4});

        int[] array = new int[]{1,2,3,4};
        testVarArg(array);

        testVarArg1(1,2, array);
    }
    public static void test(int[] ar){
        System.out.println("test");
    }
    public static void testVarArg(int  ...num){
        System.out.println("test vararg");
        System.out.println(num.length);
        System.out.println(Arrays.toString(num));
    }
    public static void testVarArg1 (int x, int y, int ...num){
        System.out.println("test vararg1");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println(num.length);
        System.out.println(Arrays.toString(num));
    }
    // CRUD - create read update delete

}
