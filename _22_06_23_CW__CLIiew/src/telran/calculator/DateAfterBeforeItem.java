package telran.calculator;

import org.junit.jupiter.api.Test;
import telran.view.InputOutput;
import telran.view.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateAfterBeforeItem implements Item {
    public InputOutput inOut;
    final String[] befAf = {"before", "after"};

    @Override
    public String displayedName() {
        return "Date after before calculator";
    }

    @Override
    public void perform() {
        LocalDate inDate = inOut.inputDate("Enter date in format: [dd-mm-yyyy]", "dd-MM-yyyy" );
        if(inDate == null){
            return;
        }
        Integer days = inOut.inputInteger("Enter days");
        if(days == null){
            return;
        }
        String beforeAfter = inOut.inputString("Enter before or after", new ArrayList<>(Arrays.stream(befAf).toList()));
        if(beforeAfter == null) {
            return;
        }
        plusMinusDays(inDate, days, beforeAfter);
    }

    static void plusMinusDays(LocalDate date, Integer days, String condition){
        if(condition.equalsIgnoreCase("after")){
            System.out.println( date.plusDays(days));
            return;
        } else {
            System.out.println( date.minusDays(days));
            return;
        }
    }

    public DateAfterBeforeItem(InputOutput inOut) {
        this.inOut = inOut;
    }

    @Override
    public boolean esExit() {
        return Item.super.esExit();
    }
}
