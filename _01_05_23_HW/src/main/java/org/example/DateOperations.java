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
                return LocalDate.parse(o1, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"))
                        .compareTo(LocalDate.parse(o2, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]")));
            }
        });
        System.out.println(datesSort);
        return datesSort.toArray(new String[0]);
    }

    public static Long getAge(String birthDate, String currentDate) {
        LocalDate birth = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        LocalDate current;
        if(currentDate != null){
            current = LocalDate.parse(currentDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        }else{
            current = LocalDate.now();
        }

        return ChronoUnit.YEARS.between(birth, current);
    }

    public static void printCurrentTime(String zoneName) {
        List<String>  zones = new ArrayList<>(ZoneId.getAvailableZoneIds());
        List<String> actualZones = new ArrayList<>();
        boolean fonded = false;
        for(String zone : zones){
            if(zone.contains(zoneName)){
                fonded = true;
                ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(zone));
                System.out.println("<" + zone + ">-" + zdt.format(DateTimeFormatter.ofPattern("hh:mm")));
            }
        }
        if(!fonded){
            System.out.println("Not correct zone");
        }
    }
}

