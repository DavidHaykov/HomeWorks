public class PrinterController {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 4;
        int totalPrints = 100;
        int portionSize = 10;
        Printer[] printers = new Printer[threadCount];

        for (int i = 0; i < threadCount; i++) {
            printers[i] = new Printer( i + 1, portionSize, totalPrints);
        }
        for (int i = 0; i < threadCount; i++) {
            printers[i].setNextThread(printers[(i + 1) % threadCount]);
        }
        for (Printer printer : printers) {
            printer.start();
        }
        printers[0].interrupt();
        Thread.sleep(1000);
    }
}
