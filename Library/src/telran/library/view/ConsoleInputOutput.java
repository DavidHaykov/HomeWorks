package telran.library.view;

import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String inputString(String prompt) {
        System.out.println(prompt + " or cancel for exit");
        String text = scanner.nextLine();
        return text.equalsIgnoreCase("cancel") ? null : text;
    }

    @Override
    public void output(Object obj) {
        System.out.println(obj);
    }
}
