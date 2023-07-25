import java.util.Arrays;

public class GroupSumParallelStream extends GroupSum{
    public GroupSumParallelStream(int[][] numbers) {
        super(numbers);
    }

    @Override
    public long computeSum() {
        return Arrays.stream(numbers).parallel().flatMapToInt(Arrays::stream).sum();
    }
}
