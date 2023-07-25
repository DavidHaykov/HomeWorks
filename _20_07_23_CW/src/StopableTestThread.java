import java.util.concurrent.atomic.AtomicBoolean;

public class StopableTestThread extends Thread{
    private AtomicBoolean stopped = new AtomicBoolean(false);

    @Override
    public void run() {
        System.out.println("Run start");
        while(!stopped.get()){
            //todo
        }
        System.out.println("Run stopped");
    }

    public void askStop(){
        System.out.println("Ask stop");
        stopped.set(true);
    }
}
