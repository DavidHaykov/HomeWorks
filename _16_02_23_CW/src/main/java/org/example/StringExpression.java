package org.example;

import java.lang.ref.SoftReference;

public class StringExpression {
    public static boolean isWord(String string){
       // return string.matches("[A-za-z][a-z]*-?[a-z]+");
        return string.matches("([A-za-z][a-z]*-?[a-z]+)|([A-Za-z][a-z]*)");
    }
    public static boolean isPositiveNumberLessThan300(String string){
       // return string.matches("[12]?\\d?\\d");
        return string.matches("([12]\\d{2})|([1-9]?\\d)");
    }
    public static boolean isTrue(String string){

        return string.matches("[tT]rue");
    }
    public static boolean isNumber(String string){
        return string.matches("\\d+");
    }
    public static boolean isThreeDigitNumber (String string){
        return string.matches("\\d{3}");
    }
    public static boolean isIsraelMobilePhone(String string){
        return string.matches("(\\+972|\\(\\+972\\)|0)-?5(-?\\d){8}");
    }

}
