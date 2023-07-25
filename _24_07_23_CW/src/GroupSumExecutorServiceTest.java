import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class GroupSumExecutorServiceTest {
    GroupSum groupSum;
    public GroupSumExecutorServiceTest(GroupSum groupSum) {
        this.groupSum = groupSum;
    }

    public void runTest(){
        Instant start = Instant.now();
        long sum  = groupSum.computeSum();
        System.out.printf("Test: %s, running time: %d, sum: %d\n", groupSum.getClass().getSimpleName(),
                ChronoUnit.MILLIS.between(start, Instant.now()), sum);
    }
}
