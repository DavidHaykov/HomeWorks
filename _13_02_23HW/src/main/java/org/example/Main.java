package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        String s = "1 2 3 4 5";
        String s2 = "5 4 3 2 1";
        System.out.println(isReverse(s, s2));
        System.out.println(isPalindrome("1 2 3 4 3 2 1"));
        printSubStringReverse(s, 1, 7);
        printStringInColumn(s2);
        System.out.println(countChar(s2, '3'));
        System.out.println(isEmailValid("bastard@gmail.com"));
        System.out.println(countSubstring("HelloHelloHello", "Hello"));
    }
        public static int countSubstring(String str, String subStr){
            if (str.contains(subStr)){
                return 1 + countSubstring(str.replaceFirst(subStr, ""), subStr);
            }
            return 0;
        }

        public static boolean isEmailValid(String email){
        if(email.isEmpty()||email.isBlank()) {
            return false;
        }
        email=email.toLowerCase().trim();
        boolean[] test = new boolean[7];
        boolean res =true;
        test[1] = true;
        test[2] = true;
        test[3] = true;
        test [0] = countChar(email,'@')==1;
        if(test[0]) {

            test[1] = email.substring(0, email.indexOf('@')).length() > 0;

            test[2] = email.substring(email.indexOf('@'), email.length()).contains(".");

           test[5] = email.substring(email.lastIndexOf(".")+1, email.length()).equals("com");
            test[6] = email.substring(email.indexOf("@")+1, email.lastIndexOf(".")).length()>0;
        }else{
            res = false;
            System.out.println("You need to use @");
        }

        char[] chars = email.toCharArray();
            for (char aChar : chars) {
                if (
                        ((int) aChar <= 45)
                                || ((int) aChar == 47)
                                || ((int) aChar >= 58 && (int) aChar <= 63)
                                || ((int) aChar >= 91 && (int) aChar <= 94
                                || ((int) aChar == 96
                                || ((int) aChar >= 123)))) {
                    test[3] = false;
                }
            }

            if(!test[1]){
                res = false;
                System.out.println("Your email must contain 1 and more symbols");
            }
            if(!test[2]){
                res = false;
                System.out.println("Domain must contain a dot");
            }
            if(!test[3]){
                res = false;
                System.out.println("Email can't contain prohibited characters or spase");
            }
            if(!test[5]){
                res = false;
                System.out.println("You need to enter 'com' after dot");
            }
            if(!test[6]){
                res = false;
                System.out.println("Enter domain");
            }
            return res;
    }

    public static int countChar(String string, char chars) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chars) {
                count++;
            }
        }
        return count;
    }
    public static void printStringInColumn(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.printf("%c\n", string.charAt(i));
        }
    }
    public static void printSubStringReverse(String string, int start, int finish) {
        System.out.println(new StringBuilder(string).reverse().substring(start, finish));
    }
    public static boolean isPalindrome(String string) {
        string = string.toLowerCase().replaceAll(" ", "");
        StringBuilder sb = new StringBuilder(string).reverse();
        return string.equalsIgnoreCase(sb.toString());
    }

    public static boolean isReverse(String string, String reverseString) {
        StringBuilder sb = new StringBuilder(reverseString).reverse();
        return string.equalsIgnoreCase(sb.toString());
    }
}
