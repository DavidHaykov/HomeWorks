package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FPAppl {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,10,5,-2,-10,20));
        List<Integer> res = find(list, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        });
        System.out.println(res);

        res = find(list, t -> t >= 0);
        System.out.println(res);

        list.sort((n1 ,n2) -> n1-n2);
        System.out.println(list);
        list.sort((n1, n2) -> {
            if(n1%2==0&&n2%2!=0){
                return -1;
            }
            if(n1%2==0&&n2%2==0){
                return -1;
            }
            if(n1%2!=0 && n2%2!=0){
                return n2-n1;
            }
            return 1;

        });
        Comparator<Integer> comp1  = (n1,n2) -> n1-n2;
        Comparator<Integer> comp2 = (n1,n2) -> {
            if(n1%2==0&&n2%2!=0){
                return -1;
            }
            if(n1%2==0&&n2%2==0){
                return -1;
            }
            if(n1%2!=0 && n2%2!=0){
                return n2-n1;
            }
            return 1;
        };
        list.sort(comp1);
        list.sort(comp2);
        System.out.println(list);
        list.sort(Integer::compare);
        System.out.println(list);


        System.out.println(list);

        list.sort(FPAppl::evenOdd);
        System.out.println(list);

        list.forEach(elem -> System.out.println(elem));
        Printable p = s -> System.out.print(s);
    }

    private static int evenOdd(int n1, int n2){
        if(n1%2==0&&n2%2!=0){
            return -1;
        }
        if(n1%2==0&&n2%2==0){
            return -1;
        }
        if(n1%2!=0 && n2%2!=0){
            return n2-n1;
        }
        return 1;
    }


    private static List<Integer> find(List<Integer> list, Predicate<Integer> pred){
        List<Integer> res = new ArrayList<>();
        for(Integer num : list){
            if (pred.test(num)) {

                res.add(num);
            }
        }
        return res;
    }
}
