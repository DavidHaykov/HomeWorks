import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CollectionAppl {
    private static final int N_THREADS = 10;
    private static final int N_NUMBERS = 100;
    private static final int N_RUNS = 1000;
    private static final int PROB_UPDATE = 50;

    public static void main(String[] args) {
        List<Integer> col = new Random().ints(N_NUMBERS, 1, 1000).boxed().collect(Collectors.toList());
        CollectionProcessingThread[] threads = new CollectionProcessingThread[N_THREADS];
        for(int i = 0; i < N_THREADS; i++){
            threads[i] = new CollectionProcessingThread(col, N_RUNS, PROB_UPDATE);
            threads[i].start();
        }
        for(int i = 0; i < N_THREADS; i++){
            try {
               threads[i].join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(CollectionProcessingThread.countLocks);
    }
}
