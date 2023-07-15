package printer;

import java.util.Arrays;

public class Printer extends Thread{
    String toPrint;

    public Printer(String toPrint) {
        this.toPrint = toPrint;
        setDaemon(true);
    }
    public void run(){
        int index = 0;
        while (true) {
            if(toPrint.isEmpty() || toPrint == null){
                break;
            }
            System.out.println(toPrint.charAt(index));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                index++;
                if(index == toPrint.length()){
                    index = 0;
                }

            }

        }
    }
}
