package org.example;

public class StringExpression {
    public static void main(String[] args) {
        
    }

    public static boolean isNumber(String s) {
        return s.matches("-?(([1-9])|([1-9][0-9]*))|-?[1-9]*[.][0-9]*|-0[.][1-9]*|0[.][1-9]*|-?0");
    }

    public static boolean isProgrammingName(String abc) {
        return abc.matches("[A-Za-z_][A-Za-z1-9_]*");
    }

    public static boolean isPositiveNumberLess1000(String s) {
        return s.matches("([1-9]\\d{2})|[1-9]?\\d");
    }

    public static boolean isPositiveNumberLessEquals255(String s) {
        return s.matches("([1-2][1-5][1-5])|[1-9]?\\d");
    }

    public static boolean isIPv4(String s) {
        return s.matches("([0-9][.][0-9][.][0-9][.][0-9])|([1-2][1-5][1-5][.][1-9]?\\d[.][1-9]?\\d[.][1-9]?\\d)|[1-2][1-5][1-5][.][1-2][1-5][1-5][.][1-2][1-5][1-5][.][1-2][1-5][1-5]");
    }

    public static boolean isEmailCoIlMailRu(String s) {

        return s.matches("[^,\s]*@[^,\s#]*([^,\s#]{3,10}[.][^,\s#]{1,3})|([^,\s#]*[.][^,\s#]*[.][^,\s#]{1,3})");
    }

    public static boolean isArithmeticExpression(String s) {
        return s.matches("( [1-9] \\+ [1-9] / [1-9])|([1-9]\\*[1-9] /[1-9])|([1-9]\\+[1-9] /[1-9])|\\d");
    }

    public static boolean checkCreditCardNumber(String s) {
        return s.matches("\\d{8}|\\d{10}|\\d{16}");
    }

    public static boolean checkDateFormatEU(String s) {
        return s.matches("([1-2][1-9]|0[1-9]|3[0-1])[.](0[1-9]|1[1-2])[.][1-2][0-9][0-9][0-9]");
    }

    public static boolean checkDateFormatUS(String s) {
        return s.matches("[1-2][0-9][0-9][0-9]-(0[1-9]|1[1-2])-([1-2][1-9]|0[1-9]|3[0-1])");
    }
}
