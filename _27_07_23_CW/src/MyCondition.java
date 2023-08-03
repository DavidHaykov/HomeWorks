public class MyCondition {
    private int count;
    static int N_THREADS = 10;
    public void barrier(){
        count++;
        if( count < N_THREADS){
            try{
                this.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        else {
            this.notifyAll();
        }
    }

}
