public class StopableAppl {
    public static void main(String[] args) throws InterruptedException {
        StopableTestThread t = new StopableTestThread();
        t.start();
        Thread.sleep(1000);
        t.askStop();
    }
}
