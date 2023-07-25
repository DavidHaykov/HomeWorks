public abstract class GroupSum {
    int [] [] numbers;

    public GroupSum(int[][] numbers) {
        this.numbers = numbers;
    }
    public abstract long computeSum();
}
