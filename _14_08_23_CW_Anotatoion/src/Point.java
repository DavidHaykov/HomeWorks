public class Point implements Cloneable{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
