import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PrinterAppl {
    private static final int N_PRINTS = 100;

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
     //   Thread.currentThread().join();

        Printer p1 = new Printer('a', N_PRINTS);
        Printer p2 = new Printer('o', N_PRINTS);
        p1.run();
        p2.run();
        p1.start();
        p2.start();
        p1.join();
        p2.join();
        System.out.printf("\nPrinting time is  %d\n", ChronoUnit.MILLIS.between(start, Instant.now()));
    }
}
