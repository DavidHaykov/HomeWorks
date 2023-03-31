package org.example;

public class Main {
    public static void main(String[] args) {
        String s = "1 2 3 4 5";
        String s1 = reverse(s);
        System.out.println(s1);
        String s2 = "5 4 3 2 1";
        System.out.println(isReverse(s, s2));
        System.out.println(isPalindrome("1 2 3 4 3 2 1"));
        printSubStringReverse(s, 1,7);
        printStringInColumn(s2);
        System.out.println(countChar(s2, '3'));
    }
    public static void validPassword(String password){
        char[] chars = password.toCharArray();
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;
        boolean length = false;
        if (chars.length>=9){
            length = true;
        }
        for (char aChar : chars) {

                if (Character.isUpperCase(aChar)) {
                    upper = true;
                }
                if (Character.isLowerCase(aChar)) {
                    lower = true;
                }
                if (Character.isDigit(aChar)) {
                    digit = true;
                }
                if (aChar == '~' || aChar == '!' || aChar == '-' || aChar == '_') {
                    special = true;
                }
        }
        if(upper&&lower&&digit&&special&&length){
            System.out.println("Correct password");
        }else {
            System.out.println("Not correct password");
            if(!length){
                System.out.println("Password must be minimum 8 symbols");
            }
            if(!upper){
                System.out.println("You need to enter minimum one upper symbol");
            }
            if(!lower){
                System.out.println("You need to enter minimum one lower symbol");
            }
            if(!digit){
                System.out.println("You need to enter minimum one digit");
            }
            if(!special){
                System.out.println("You need to enter minimum one special symbol - '~' '!' '-' '_'");
            }
        }
    }
    public static int countChar(String string, char chars){
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chars) {
                count++;
            }
        }
        return count;
    }
    public static void printStringInColumn(String string){
        for (int i = 0; i < string.length(); i++) {
            System.out.printf("%c\n", string.charAt(i));
        }
    }
    public static void printSubStringReverse(String string, int start, int finish){
        System.out.println(reverse(string.substring(start,finish)));
    }
    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }
    public static boolean isReverse(String string, String reverseString){
        return string.equalsIgnoreCase(reverse(reverseString));
    }
    public static String reverse(String string){
        StringBuilder res = new StringBuilder();
        for(int i = string.length(); i> 0; i--){
            res.append(string.charAt(i-1));
        }
        return res.toString();
    }
}
