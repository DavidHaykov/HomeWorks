package org.example;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.Scanner;

public class ExeptionAppl {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Start");
        while (true) {
            try {
                System.out.println("enter number");
                String str = scanner.nextLine();
                int res = getNum(str);
                System.out.println("number =" + res);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("empty args");
            }
            catch (NumberFormatException | NullPointerException ex){
                System.out.println("not int - " + ex.getStackTrace());
                args[0] = "1111";
            }
        }

        System.out.println("Finish");
        System.out.println(isNumber("111.1"));
        System.out.println(isNumber("111"));
        System.out.println(isNumber("abc"));
    }
    public static boolean isNumber(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
        finally {
            System.out.println("finaly");
        }
    }
    public static int getNum(String str){

        return Integer.parseInt(str);
    }

}
