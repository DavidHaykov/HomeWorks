package org.example;

import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NonLeapYears implements TemporalAdjuster {
int nYears;

    public NonLeapYears(int nYears) {
        this.nYears = nYears;
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
        int count = 0;
        while(count  < nYears){
            temporal = temporal.plus(1, ChronoUnit.YEARS);
            if(!Year.isLeap(temporal.get(ChronoField.YEAR))){
                count++;
            }
        }
        return temporal;
    }
}
