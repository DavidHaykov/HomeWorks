import java.util.Random;
import java.util.function.Function;

public class TreadsRacing implements Runnable{
int threadNumber;
int runNum;
static boolean winner = false;
public static final int DESTINATION = 100;

    public TreadsRacing(int threadNumber) {
        this.threadNumber = threadNumber;
        this.runNum = 0;

    }

    @Override
    public void run() {
        while(!winner) {
            if (this.runNum < DESTINATION) {
                System.out.println(this.threadNumber);
                this.runNum++;
            } else {
                System.out.println("Congratulations to thread #" + this.threadNumber);
                winner = true;
            }
            try {
                Thread.sleep(getRandSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private long getRandSleepTime() {
        Random rand = new Random();
        return rand.nextLong(4) + 2;
    }
    public static boolean haveWinner(){
        return winner;
    }
}
