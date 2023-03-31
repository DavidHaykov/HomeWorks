
package org.example;

import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateAppl {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,};
        int[] oddNumbers = getNumbers(array, new OddNumbersPredicate());
        int[] evenNumbers = getNumbers(array, new EvenNumbersPredicate());
        int[] evenNumbers1 = getNumbers(array, new OddNumbersPredicate().negate());
        int[] oddNumbersDiv3 = getNumbers(array,
                new OddNumbersPredicate().and(new ThreeNumbersPredicate()));
        int[] threeNumbers = getNumbers(array, new ThreeNumbersPredicate());
        int[] allNumbers = getNumbers(array,
                new EvenNumbersPredicate().or( new OddNumbersPredicate()));



        displayArray("odd", oddNumbers);
        displayArray("even", evenNumbers);
        displayArray("even 1", evenNumbers1);
        displayArray("three", threeNumbers);
        displayArray("OddThree", oddNumbersDiv3);
        displayArray("all", allNumbers);
    }

    private static int[] getNumbers(int[] array, Predicate<Integer> pred){
        int[] temp = Arrays.copyOf(array, array.length);
        int indexRes = 0;
        for(int i = 0; i< temp.length;i++){
            if(pred.test(temp[i])){
                temp[indexRes++]= temp[i];
            }
        }
        return Arrays.copyOf(temp,indexRes);
    }
    private static void displayArray(String string, int[] array){
        System.out.println(string);
        System.out.println(Arrays.toString(array));
    }
}
