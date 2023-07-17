import org.w3c.dom.html.HTMLImageElement;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class ThreadsRacing extends Thread{
    int runNum;
    static int place = 1;
    public static final int DESTINATION = 100;
    Instant startTime;
    int threadNumber;

    public ThreadsRacing(int threadNumber) {
        this.runNum = 0;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        startTime = Instant.now();
        while(!isInterrupted()){
            if(this.runNum < DESTINATION){
                this.runNum++;
                try {
                    sleep(getRandSleepTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                finishRacing();
                return;
            }
        }
    }

    private synchronized void finishRacing() {
        if(place <= 3) {
            Instant finishTime = Instant.now();
            long racingTime = ChronoUnit.MILLIS.between(startTime, finishTime);
            System.out.printf("%d%15s%25d%n", place, threadNumber, racingTime);
        }
        place++;
    }

    private long getRandSleepTime() {
        Random rand = new Random();
        return rand.nextInt(4) + 2;
    }
}
