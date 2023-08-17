@A
public class Y {
    int x;
    @B("Hello")
    int y;
    @B(value = "kuku", number = 10, unique = false)
    String str;

    public Y(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
    }

}
