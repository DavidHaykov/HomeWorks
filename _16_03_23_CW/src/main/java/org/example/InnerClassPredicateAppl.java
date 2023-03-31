
package org.example;

import java.util.Arrays;
import java.util.function.Predicate;

public class InnerClassPredicateAppl {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,};
        int[] oddNumbers = getNumbers(array, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer %2!=0;
            }
        });
        int[] evenNumbers = getNumbers(array, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        });
        int[] threeNumbers = getNumbers(array, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%3==0;
            }
        });
        int[] rangeNumbers2to7 = getNumbers(array, new RangePredicate(2,7));


        displayArray("odd", oddNumbers);
        displayArray("even", evenNumbers);
        displayArray("three", threeNumbers);
        displayArray("2 to 7", rangeNumbers2to7);

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
        System.out.println("*************");
    }
}

