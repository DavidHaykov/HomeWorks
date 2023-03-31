package org.example.point;

import java.util.SortedMap;

public class Point {
    public int x;
    public int y;
    public static double pi = 3.14;
    public static int count = 0;

    public static void print(String string){
        System.out.println(string);
    }
    public static String getString(String str){
        return str.toLowerCase();
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        count++;

    }

    public Point() {
        count++;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
