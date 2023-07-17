public class Printer extends Thread{
    private final int TOTAL_PRINTS;
    private final int THREAD_NUMBER;
    private final int PRINT_PORTION;
    int printsDone;
    private Thread nextThread;

    public Printer(int TOTAL_PRINTS, int THREAD_NUMBER, int PRINT_PORTION) {
        this.TOTAL_PRINTS = TOTAL_PRINTS;
        this.THREAD_NUMBER = THREAD_NUMBER;
        this.PRINT_PORTION = PRINT_PORTION;
        setDaemon(true);
    }
    public void setNextThread(Thread nextThread){
        this.nextThread = nextThread;
    }
    private void printPortion(){
        for(int i = 0; i < PRINT_PORTION; i++){
            System.out.print(THREAD_NUMBER);
        }
        System.out.println();
    }

    @Override
    public void run() {
        while (printsDone < TOTAL_PRINTS) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                printPortion();
                printsDone += PRINT_PORTION;
                nextThread.interrupt();
            }
        }
    }
}
