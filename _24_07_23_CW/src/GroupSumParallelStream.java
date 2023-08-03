import java.util.Arrays;

public class GroupSumParallelStream extends GroupSum{
    public GroupSumParallelStream(int[][] numbers) {
        super(numbers);
    }

    @Override
    public long computeSum() {
        return Arrays.stream(numbers).parallel().mapToLong(g -> Arrays.stream(g).asLongStream().sum()).sum();
    }
}
