import java.util.Scanner;

public class RacingAppl {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the threads number");
        int threadsNumber = Integer.parseInt(scanner.nextLine());
        if(threadsNumber < 2){
            System.out.println("Error");
            return;
        }
        ThreadsRacing[] threads = new ThreadsRacing[threadsNumber];
        System.out.printf("\n%s%17s%20s%n", "Place", "Thread number", "Time\n");
        for(int i = 0; i < threads.length; i++){
            threads[i] = new ThreadsRacing(i+1);
            threads[i].start();
        }
        for(ThreadsRacing t : threads){
            t.join();
        }
    }
}