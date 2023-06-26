package telran.calculator;

import org.junit.jupiter.api.Test;
import telran.view.*;

public class CalculatorAppl {
    public static void main(String[] args) {
        InputOutput inOut = new ConsoleInputOutput();
        Item[] items = {
                new CalculatorItem(inOut),
                new DateAfterBeforeItem(inOut),
                new DaysBetweenItem(inOut),
                new ExitItem()
        };
        Menu menu = new Menu(items, inOut);
        menu.runMenu();
    }
}
