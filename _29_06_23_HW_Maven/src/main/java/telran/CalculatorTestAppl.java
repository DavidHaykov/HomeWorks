package telran;


import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class CalculatorTestAppl {
    static InputOutput inOut = new ConsoleInputOutput();
    static CalculatorClient calculator;

    static {
        try {
            calculator = new CalculatorClient("localhost", 3000);
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
                new ExitItem()
        };
        return res;
    }

}
