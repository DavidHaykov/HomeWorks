public class Printer extends Thread {
    private Thread nextThread;
    private final int number;
    private final int portionSize;
    private final int totalPrints;
    int printsDone = 0;

    public Printer(int number, int portionSize, int totalPrints) {
        this.number = number;
        this.portionSize = portionSize;
        this.totalPrints = totalPrints;
        setDaemon(true);
    }

    public void setNextThread(Thread nextThread) {
        this.nextThread = nextThread;
    }
    private void printPortion(){
        for(int i = 0; i < portionSize; i++){
            System.out.print(number);
        }
        System.out.println();
    }

    @Override
    public void run() {
        while(printsDone < totalPrints){
            try {
                sleep(1);
            }catch (InterruptedException e){
                printPortion();
                printsDone += portionSize;
                nextThread.interrupt();
            }
        }
    }
}
