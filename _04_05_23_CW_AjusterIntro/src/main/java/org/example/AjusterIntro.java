package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class AjusterIntro {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(date.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println(date.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println(date.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY)));

        TemporalAdjuster lastDayYear = TemporalAdjusters.lastDayOfYear();
        LocalDate lastday = date.with(lastDayYear);
        Period until = date.until(lastday);
        System.out.println(until.getDays());
        System.out.println("Until New Year: " + "years " + until.getYears() + " month "
                + until.getMonths() + " days " + until.getDays());
        System.out.println(ChronoUnit.DAYS.between(date, lastday));

        System.out.println(date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));
        System.out.println(date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));

        System.out.println(date.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)));
        System.out.println(date.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY)));

        System.out.println(date.with(new NonLeapYears(10)));

    }
}
