public class TimerAppl {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        //timer.setDaemon(true);
        timer.setFormat("hh:mm:ss a");
        timer.start();

        Thread.sleep(5000);
        timer.interrupt();
        Thread.sleep(5000);
        timer = new Timer();
        timer.start();
        Thread.sleep(5000);

    }
}
