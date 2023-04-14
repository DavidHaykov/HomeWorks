package org.example;

public class Rectangle  implements Comparable<Rectangle>{
    int x;
    int y;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Rectangle o) {
        int temp = x - o.x;
        return temp == 0 ? y-o.y: temp;
    }
}
