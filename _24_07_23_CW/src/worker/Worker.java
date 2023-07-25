package worker;

public class Worker extends Thread{
    private static final Object mutex1 = new Object();
    private static final Object mutex2 = new Object();
    int nRuns = 5;
    void method1(){
        synchronized (mutex1){
            try {
                sleep(10);
            }catch (InterruptedException ignored){

            }
            synchronized (mutex2){

            }
        }
    }
    void method2(){
        synchronized (mutex2){
            try {
                sleep(10);
            }catch (InterruptedException ignored){

            }
            synchronized (mutex1){

            }
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < nRuns; i++){
            method1();;
            method2();
        }
    }
}
