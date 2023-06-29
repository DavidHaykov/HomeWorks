package telran;

import telran.net.TcpClientJava;
import telran.net.server.ServerJava;
import telran.view.*;

import java.io.IOException;

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
