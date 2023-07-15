import java.util.Scanner;

public class ThreadsRacingAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the threads number");
        int threadsNumber = Integer.parseInt(scanner.nextLine());
        if(threadsNumber < 2) {
            System.out.println("Error");
            return;
        }
        TreadsRacing[] array = new TreadsRacing[threadsNumber];
        Thread[] threads = new Thread[threadsNumber];
        for(int i = 0; i<array.length; i++){
            array[i] = new TreadsRacing(i+1);
            threads[i] = new Thread(array[i]);
        }
        for(Thread t : threads){
            t.start();
        }
    }
}
