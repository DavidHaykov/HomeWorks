public class PrinterController {
    public static final int N_THREADS = 4;
    public static final int TOTAL_PRINTS = 100;
    public static final int PRINT_PORTION = 10;
    public static void main(String[] args) throws InterruptedException {
       Printer[] printers = new Printer[N_THREADS];
       for(int i = 0; i < N_THREADS; i++){
           printers[i] = new Printer(TOTAL_PRINTS, i+1, PRINT_PORTION);
       }
       for(int i = 0; i < N_THREADS; i++){
           printers[i].setNextThread(printers[(i+1)%N_THREADS]);
       }
       for(Printer printer : printers){
           printer.start();
       }
       printers[0].interrupt();
       Thread.sleep(1);
    }
}