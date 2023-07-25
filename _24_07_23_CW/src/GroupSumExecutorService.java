import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GroupSumExecutorService extends GroupSum{
    int nThreads;

    public GroupSumExecutorService(int[][] numbers) {
        super(numbers);
        Runtime runtime =  Runtime.getRuntime();
        nThreads = runtime.availableProcessors();

    }

    @Override
    public long computeSum() {
        ExecutorService pool = Executors.newFixedThreadPool(nThreads);
        OneGroupSum[] groups = launchExecutor(pool);
        waitThreads(pool);
        return computeGroups(groups);
    }

    private long computeGroups(OneGroupSum[] groups) {
        return Arrays.stream(groups).mapToLong(e -> e.sum).sum();
    }

    private void waitThreads(ExecutorService pool) {
        pool.shutdown();
        try {
            pool.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private OneGroupSum[] launchExecutor(ExecutorService pool) {
        OneGroupSum[] res = new OneGroupSum[numbers.length];
        for(int i = 0; i < res.length; i++){
            res[i] = new OneGroupSum(numbers[i]);
            pool.execute(res[i]);
        }
        return res;
    }
}
