public class StopableTestThread extends Thread{
    private boolean stopped = false;

    @Override
    public void run() {
        System.out.println("Run start");
        while(!stopped){
            //todo
        }
        System.out.println("Run stopped");
    }

    public void askStop(){
        System.out.println("Ask stop");
        stopped = true;
    }
}
