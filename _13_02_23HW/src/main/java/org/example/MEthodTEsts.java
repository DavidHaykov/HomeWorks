package org.example;

public class MEthodTEsts {
    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
        char test = '@';
        System.out.println((int)test);
    }
    public static String reverse (String string){
        StringBuilder sb = new StringBuilder(string);
        sb = sb.reverse();
        return sb.toString();

    }
}
