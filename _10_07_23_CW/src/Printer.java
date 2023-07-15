public class Printer extends Thread{
    char symbol;
    int nPrints;

    public Printer(char symbol, int nPrints) {
        this.symbol = symbol;
        this.nPrints = nPrints;
    }
    public void run(){
        for(int i =0; i < nPrints; i++){
            System.out.print(symbol);
            try {
                sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
