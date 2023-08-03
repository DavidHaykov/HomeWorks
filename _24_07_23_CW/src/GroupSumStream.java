import java.util.Arrays;

public class GroupSumStream extends GroupSum{
    public GroupSumStream(int[][] numbers) {
        super(numbers);
    }

    @Override
    public long computeSum() {
        return Arrays.stream(numbers).mapToLong(g -> Arrays.stream(g).asLongStream().sum()).sum();
    }
}
