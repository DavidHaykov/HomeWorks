package org.example.point;

public class PointAppl {
    public static void main(String[] args) {
        Point p = new Point(1, 1);
        Point p1 = new Point(2,2);
        Point p2 = new Point();
        System.out.println(p.x);
        System.out.println(p1.x);
        System.out.println(p.pi);
        System.out.println(p1.pi);
        System.out.println(Point.pi);
        System.out.println(Point.count);
        p2.print("Hello");
        Point.print("Hello");

    }
}
