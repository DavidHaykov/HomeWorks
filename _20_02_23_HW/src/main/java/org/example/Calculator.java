package org.example;

public class Calculator {


    public static int sum(int x, int y) {
        return x + y;
    }

    public static int div(int x, int y) {
        return x / y;
    }

    public static int mul(int x, int y) {
        return x * y;
    }

    public static int sub(int x, int y) {
        return x - y;
    }

    public static Object computeExpression(String string) {
        if(!isArithmeticExpression(string)){
            return null;
        }

        string = string.trim();
        String[] operands = getOperands(string);
        String[] operators = getOperators(string);
        Integer res = Integer.parseInt(operands[0]);
        for(int i = 0; i< operands.length; i++){
            res = computeOne(res, operands[i], operators[i]);
        }

        return res;
    }
    public static Integer computeOne(Integer res, String operand, String operator){
        Integer number = Integer.parseInt(operand);
        switch (operator){
            case "+":
                return sum(res, number);
            case "-":
                return sub(res, number);
            case "*":
                return mul(res, number);
            case "/":
                return div(res, number);
            default: return res;

        }

    }
    private static String[] getOperands(String string){
        return string.split("\\D+");
    }
    private static String[] getOperators(String string){
        return string.split("[\\s\\d]+");
    }
    public static boolean isArithmeticExpression(String string)
    {
        return string.matches("\\s*\\d+(\\s*[*+/-]\\s*\\d+)*\\s*");
    }
}
