import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class PrintCalendarAppl {
    public static void main(String[] args) {
        int[] monthYear = args.length == 2 ? getMonthYear(args) : GetCurrentMonthYear();
        if(monthYear == null){
            System.out.println("Wrong input, must be <month number> <year number>");
            return;
        }
        printMonthYear(monthYear[0], monthYear[1]);
        System.out.println("\n");
    }

    private static void printMonthYear(int month, int year) {
        printTitle(month, year);
        printWeekDayNames();
        printDates(month, year);

    }

    private static void printDates(int month, int year) {
        System.out.println("\n");

        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate firstDayOfTheMonth = yearMonth.atDay(1);
        int firstDay = firstDayOfTheMonth.getDayOfWeek().getValue();


        boolean flag = false;
        for(int i = 1, j = 1; j <= Month.of(month).maxLength(); i++){
            if(i < firstDay){
                System.out.printf("%4s", " ");
            }
            if(i == firstDay){
                flag = true;
            }
            if(flag){
                System.out.print("\t" + j);
                j++;
                if(i%7==0){
                    System.out.print("\n");
                }
            }
        }

    }

    private static void printWeekDayNames() {
        System.out.print("\t");
        for(int i = 1; i<=7 ; i++){
            DayOfWeek day = DayOfWeek.of(i);
            String dayStr = day.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
            System.out.print(dayStr + " ");
        }
    }

    private static void printTitle(int month, int year) {
        Month m = Month.of(month);
        String mStr = m.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("en"));
        System.out.printf("%12s%s %d\n"," ", mStr, year);
    }

    private static int[] GetCurrentMonthYear() {
        LocalDate current = LocalDate.now();
        return new int[]{current.getMonthValue(), current.getYear()};
    }

    private static int[] getMonthYear(String[] args) {
        int[] res = new int[2];
        try{
            res[0] = Integer.parseInt(args[0]);
            res[1] = Integer.parseInt(args[1]);
            if(res[0] < 1 || res [0] > 12){
                return null;
            }
        }catch (Exception e){
            return null;
        }
        return res;
    }
}
