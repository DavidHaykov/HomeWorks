package org.example;

import java.util.Comparator;
import java.util.Iterator;

public class WeightAgeComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        int res  = Double.compare(o1.weight, o2.weight);
        if(res==0){
            res = Integer.compare(o1.age, o2.age);
        }
        return res;
    }
}
