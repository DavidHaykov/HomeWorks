package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class DateOperations {
    public static String[] sortStringDates(String[] dates) {
        List<String> datesSort = new ArrayList<>(List.of(dates));
        datesSort.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(LocalDate.parse(o1, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getYear()!=LocalDate.parse(o2, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getYear()) {
                    return LocalDate.parse(o1, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getYear() - LocalDate.parse(o2, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getYear();
                }else if(LocalDate.parse(o1, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getMonth()!=LocalDate.parse(o2, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getMonth()){
                    return LocalDate.parse(o1, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getMonth().compareTo(LocalDate.parse(o2, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getMonth());
                }else if(LocalDate.parse(o1, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getDayOfMonth()!=LocalDate.parse(o2, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getDayOfMonth()){
                    return LocalDate.parse(o1, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getDayOfMonth() - LocalDate.parse(o2, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")).getDayOfMonth();
                }else {
                    return 0;
                }
            }
        });


        System.out.println(datesSort);
        return datesSort.toArray(new String[0]);
    }

    public static Long getAge(String birthDate, String currentDate) {
        LocalDate birth = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        LocalDate current = LocalDate.parse(currentDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        return ChronoUnit.YEARS.between(birth, current);
    }

    public static void printCurrentTime(String zoneName) {
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(zoneName));
        System.out.println("<" + zoneName + ">-" + zdt.format(DateTimeFormatter.ofPattern("hh:mm")));
    }
}

