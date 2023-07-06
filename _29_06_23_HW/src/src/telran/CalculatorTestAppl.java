package src.telran;




import view.ConsoleInputOutput;
import view.InputOutput;
import view.Item;
import view.Menu;

import java.io.IOException;

public class CalculatorTestAppl {
    static InputOutput inOut = new ConsoleInputOutput();
    static CalculatorClient calculator;

    static {
        try {
            calculator = new CalculatorClient("localhost", 4400);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws Exception {

        Menu menu = new Menu(getMainMenuItems(), inOut);
        menu.runMenu();
    }

    private static Item[] getMainMenuItems() {
        Item[] res = {
                new CalculatorItem(calculator, inOut),
                new CloseAndExitItem(calculator, inOut)
        };
        return res;
    }

}
