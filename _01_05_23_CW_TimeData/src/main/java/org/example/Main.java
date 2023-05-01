package org.example;
import  java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //localDate
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDate date1 = LocalDate.of(2000, 10, 10);
        LocalDate date2 = LocalDate.of(2000, Month.OCTOBER, 10);
        System.out.println(date1);
        System.out.println(date2);
        LocalDate date3 = LocalDate.parse("2000-12-29");
        LocalDate date4 = LocalDate.ofYearDay(2020, 300);
        System.out.println(date4);
        System.out.println(date1.getDayOfYear());

        System.out.println(date.plus(1, ChronoUnit.CENTURIES));
        System.out.println(date.minus(1, ChronoUnit.MILLENNIA));

        LocalTime time = LocalTime.of(10, 10);
        System.out.println(time.plus(Duration.ofMinutes(10)));


        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        //Formatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd/MMM/yyyy hh:mm:ss a", Locale.forLanguageTag("he"));
        System.out.println(ldt.format(dtf));

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);

        for(String str : ZoneId.getAvailableZoneIds()){
            System.out.println(str);
        }

        ZonedDateTime almatyTime =  ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Almaty"));
        System.out.println(almatyTime);
        ZonedDateTime nyTime = almatyTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(nyTime);
    }

}