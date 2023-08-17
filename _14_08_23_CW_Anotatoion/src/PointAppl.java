public class PointAppl {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point p = new Point(1,1);
        System.out.println(p);
        Point p1 = p;
        System.out.println(p1);
        Point p2 = (Point) p.clone();
        System.out.println(p2);


    }
}
