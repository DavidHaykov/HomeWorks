package telran.calculator;

import org.junit.jupiter.api.Test;
import telran.view.InputOutput;
import telran.view.Item;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetweenItem implements Item {
    InputOutput inOut;

    public DaysBetweenItem(InputOutput inOut) {
        this.inOut = inOut;
    }

    @Override
    public String displayedName() {
        return "Days between calculator";
    }

    @Override
    public void perform() {
        LocalDate date1 = inOut.inputDate("Enter first date in format: [dd-mm-yyyy]", "dd-MM-yyyy");
        if(date1 == null){
            return;
        }
        LocalDate date2 = inOut.inputDate("Enter second date in format: [dd-mm-yyyy]", "dd-MM-yyyy");
        if(date2 == null){
            return;
        }
        displayDaysBetween(date1, date2);

    }
    static void displayDaysBetween(LocalDate first, LocalDate second){
        System.out.println(ChronoUnit.DAYS.between(first, second));
    }


}
