package printer;

import java.util.Scanner;

public class PrinterAppl {
    public static void main(String[] args) throws InterruptedException {


        Printer printer = new Printer("abcde");
        printer.start();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String res = scanner.nextLine();
            if(res.equals("q")){
                return;
            }else {
                printer.interrupt();
            }
        }
    }
}
