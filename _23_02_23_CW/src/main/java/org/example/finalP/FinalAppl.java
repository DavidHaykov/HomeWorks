package org.example.finalP;

public class FinalAppl {
    final int y = 10;
    public static void main(String[] args) {
        final int x = 10;
        Worker w = new Worker();

        w.work();

        WhiteWorker ww = new WhiteWorker();
        ww.work();

    }


}
