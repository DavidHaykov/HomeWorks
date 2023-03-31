package org.example;

public class Exeptions {
    public static void main(String[] args) {
        int x = 1;
        if(x < 10){
            x--;
            try {
                throw new MyExeption("Number must be equals 10");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        try {
            method(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(div(10,0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void method(int x) throws Exception {
        System.out.println("Method");
        if(x>=0) {
            throw new IllegalAccessException("You can't invoke this method");
        }else {
            throw new NullPointerException();
        }

    }

    public static int div(int x, int y) throws ArithmeticException {
        return x/y;
    }
}