package org.example;
import java.util.Objects;


public class MInMaxValues {


    public static void main(String[] args) {
        for (String arg : args) {
            if(arg.isEmpty()||arg==null) {
                return;
            }

            if (Objects.equals(arg, "int")) {
                System.out.println(arg + " Max value = " + Integer.MAX_VALUE + " Min value = " + Integer.MIN_VALUE);
            } else if (Objects.equals(arg, "char")) {
                System.out.println(arg + " Max value = " + (int) Character.MAX_VALUE + " Min value = " + (int) Character.MIN_VALUE);
            } else if (Objects.equals(arg, "long")) {
                System.out.println(arg + " Max value = " + Long.MAX_VALUE + " Min value = " + Long.MIN_VALUE);
            } else if (Objects.equals(arg, "short")) {
                System.out.println(arg + " Max value = " + Short.MAX_VALUE + " Min value = " + Short.MIN_VALUE);
            } else if (Objects.equals(arg, "double")) {
                System.out.println(arg + " Max value = " + Double.MAX_VALUE + " Min value = " + Double.MIN_VALUE);
            } else if (Objects.equals(arg, "float")) {
                System.out.println(arg + " Max value = " + Float.MAX_VALUE + " Min value = " + Float.MIN_VALUE);
            } else if (Objects.equals(arg, "byte")) {
                System.out.println(arg + " Max value = " + Byte.MAX_VALUE + " Min value = " + Byte.MIN_VALUE);
            } else {
                System.out.println(arg + " is wrong type");
            }
        }

    }


}
