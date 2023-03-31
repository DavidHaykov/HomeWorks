package org.example;


public class StringBuilderAppl {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        StringBuilder sb1 = new StringBuilder(50);
        System.out.println(sb1.length());
        System.out.println(sb1.capacity());
        StringBuilder sb2 = new StringBuilder("Hello");
        System.out.println(sb2.length());
        System.out.println(sb2.capacity());
        sb = new StringBuilder(1);
        sb.append("He");
        System.out.println(sb.capacity());
        sb.append("Hello");
        System.out.println(sb.capacity());
        System.out.println(sb);
        sb.deleteCharAt(0);
        System.out.println(sb);
        System.out.println(sb.capacity());
        sb.trimToSize();
        System.out.println(sb.length());
        System.out.println(sb.capacity());
    }
}
