package org.example;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class StringAppl {

    public static void main(String[] args) {

        String s ="Hello";
        String s1 = new String();
        String s2 = new String("world");
        String s3 = new String(new char[] {'h','e','l','l','o'});
        char[] res = {'h', 'e', 'l', 'l', 'o'};
        String s4 = new String(res);
        String s5 = new String(res, 2, 2);
        System.out.println(s5);
        System.out.println(s3.length());

        char[] chars = s3.toCharArray();
        System.out.println(Arrays.toString(chars));
        System.out.println(s1.isEmpty());
        System.out.println(s3.isEmpty());
        System.out.println(s1.isBlank());
        System.out.println(s3.isBlank());
        String s6 = "           ";
        System.out.println(s6.isBlank());
        System.out.println(s6.isEmpty());
        System.out.println(s + " " + s2 + "!");
        System.out.println(s.concat(" ").concat(s2).concat("!"));
        System.out.println(s + " " + null + "!");
        //System.out.println(s.concat(" ").concat(null).concat("!"));            ERROR  -  NULL PROTECTION
        System.out.println(String.join(" ", s,s1,s2,s3,s4,s5));

        s = "Hello";
        s1 ="Hello";
        s2 ="hello";
        s3 ="HELLO";
        System.out.println(s.equals(s1));
        System.out.println(s.equals(s2));
        System.out.println(s.equalsIgnoreCase(s2));   // 'A' equal 'a'
        System.out.println(s.compareTo(s1));
        System.out.println(s.compareTo(s2));
        System.out.println(s2.compareTo(s));
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s.compareTo("Hello world"));
        s5 = "Hello world";
        System.out.println(s5.regionMatches(false/*Not must*/, 5,"I work", 1,4)); // line 48 ^
        System.out.println(s5.charAt(0));
        System.out.println(s5.indexOf('l'));
        System.out.println(s5.lastIndexOf('l'));
        System.out.println(s5.startsWith("Hell"));
        System.out.println(s5.endsWith("orld"));
        System.out.println(s5.lastIndexOf('l', 3));
        System.out.println(s5.indexOf('l', 3));
        System.out.println(s5.indexOf("llo"));
        System.out.println(s5.lastIndexOf("llo"));

        char[] dest = new char[4];
        s5.getChars(1, 5, dest, 0);
        System.out.println(dest);
        System.out.println(s5.substring(2));
        System.out.println(s5.substring(2, 6));

        System.out.println(s5.toUpperCase());
        System.out.println(s5.toLowerCase());
        System.out.println(s5.concat(" ").repeat(3));
        System.out.println("      hello        ".trim());
        System.out.println(s5.replace('l', 'h'));
        String res2 = "Two beer or not two beer";
        String[] words = res2.split(" ");
        System.out.println(Arrays.toString(words));
        System.out.println(getCharsSum("1 2 3 45 9"," "));
    }
    
    public static int getCharsSum(String chars, String dec){
        int sum = 0;
        if(chars ==null|| dec == null||chars.isBlank()){
            System.out.println("Error");
            return 0;
        }
        String[] array = chars.split(dec);
        for(String str : array){
            if(isDigitChars(str)) {
                sum += Integer.parseInt(str);
            }else {
                System.out.println("Wrong type");
            }
        }

        return sum;
    }
    public static boolean isDigitChars(String chars){
        boolean is = false;
        int x;
        try {
            x = Integer.parseInt(chars);
            is = true;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
return is;
    }

}
