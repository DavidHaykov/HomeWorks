package org.example;




public class MinMax {

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Integer"+" Max value = " + Integer.MAX_VALUE + " Min value = " + Integer.MIN_VALUE);
            System.out.println("Byte"+" Max value = " + Byte.MAX_VALUE + " Min value = " + Byte.MIN_VALUE);
            System.out.println("Short"+" Max value = " + Short.MAX_VALUE + " Min value = " + Short.MIN_VALUE);
            System.out.println("Character"+" Max value = " + (int)Character.MAX_VALUE + " Min value = " + (int)Character.MIN_VALUE);
            System.out.println("Long"+" Max value = " + Long.MAX_VALUE + " Min value = " + Long.MIN_VALUE);
            System.out.println("Double"+" Max value = " + Double.MAX_VALUE + " Min value = " + Double.MIN_VALUE);
            System.out.println("Float"+" Max value = " + Float.MAX_VALUE + " Min value = " + Float.MIN_VALUE);
        }
        for (String arg : args) {


            Object x = null;

            try {
                x = Byte.parseByte(arg);
                System.out.println("Byte"+" Max value = " + Byte.MAX_VALUE + " Min value = " + Byte.MIN_VALUE);
            } catch (NumberFormatException e) {

                try {
                    x = Short.parseShort(arg);
                    System.out.println("Short"+" Max value = " + Short.MAX_VALUE + " Min value = " + Short.MIN_VALUE);
                } catch (NumberFormatException ex) {
                    try {
                        x = Integer.parseInt(arg);
                        System.out.println("Integer"+" Max value = " + Integer.MAX_VALUE + " Min value = " + Integer.MIN_VALUE);
                    } catch (NumberFormatException exc) {
                        try {
                            x = Long.parseLong(arg);
                            System.out.println("Long"+" Max value = " + Long.MAX_VALUE + " Min value = " + Long.MIN_VALUE);
                        } catch (NumberFormatException numberFormatException) {
                            try {
                                x = Float.parseFloat(arg);
                                System.out.println("Float"+" Max value = " + Float.MAX_VALUE + " Min value = " + Float.MIN_VALUE);
                            } catch (NumberFormatException formatException) {
                                try {
                                    x = Double.parseDouble(arg);
                                    System.out.println("Double"+" Max value = " + Double.MAX_VALUE + " Min value = " + Double.MIN_VALUE);
                                } catch (NumberFormatException exception) {
                                    try {
                                        if(arg.length()<=1) {
                                            x = arg.charAt(0);
                                            System.out.println("Character" + " Max value = " + (int) Character.MAX_VALUE + " Min value = " + (int) Character.MIN_VALUE);
                                        }else {
                                            System.out.println("Wrong Type");
                                        }
                                    } catch (Exception e1) {
                                        System.out.println("Wrong type");

                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}



