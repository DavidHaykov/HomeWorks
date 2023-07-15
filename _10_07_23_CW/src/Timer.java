import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread{
    int timeUnit = 1000;
    String format = "HH:mm:ss";

    public void setFormat(String format) {
        this.format = format;
    }

    public Timer() {
        setDaemon(true);
    }

    public void run(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        while(true){
            LocalTime lt = LocalTime.now();
            System.out.println(lt.format(dtf));
            try {
                sleep(timeUnit);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
