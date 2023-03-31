import java.util.Scanner;

public class Metods {
    public static void main(String[] args) {
        display();
        String name = "Ivan";
        printName(name);
        printName("Julia");
        int res = getNumber();
        System.out.println(res);
        System.out.println(sum(10, getNumber()));
        System.out.println(sum(10, res));

    }

    public static void display() {
        System.out.println("Hello world!");

    }
    public static void printName(String name){
        System.out.println("Hello " + name);
        System.out.printf("Hello %s\n", name);
    }
    public static int getNumber(){

        return 100;
    }
    public static int sum(int x, int y){
        return x+y;
    }

}
