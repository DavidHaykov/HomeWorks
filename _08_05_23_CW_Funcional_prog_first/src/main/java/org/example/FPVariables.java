package org.example;

public class FPVariables {
    static int x = 10;
    static int y = 20;

    public static void main(String[] args) {
        Operation op = () -> x+y;
        System.out.println(op.calculate());
        op = () -> {
            x = 30;
            return x+1;
        };
        System.out.println(op.calculate());
        int num = 100;
        int num1 = 200;
        op = () -> num1 + num;
    }
}

interface Operation {
    int calculate();
}
