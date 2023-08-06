import java.util.Random;

public class GroupSumAppl {
    private static final int N_GROUPS = 1000;
    private static final  int N_NUMBER_PER_GROUP = 100000;

    public static void main(String[] args) {
        int[][] numbers = getRandomNumbers();
        for(String className : args) {
            GroupSum groupSum;
            switch (className) {
                case "GroupSumThreads":
                    groupSum = new GroupSumThreads(numbers);
                    break;
                case "GroupSumStream":
                    groupSum = new GroupSumStream(numbers);
                    break;
                case "GroupSumParallelStream":
                    groupSum = new GroupSumParallelStream(numbers);
                    break;
                default:
                    System.out.println("Invalid class name: " + className);
                    continue;
            }
            GroupSumExecutorServiceTest test = new GroupSumExecutorServiceTest(groupSum);
            test.runTest();
        }

    }

    private static int[][] getRandomNumbers() {
        Random random = new Random();
        int[][] res= new int[N_GROUPS][];
        for(int i = 0; i < N_GROUPS; i++){
            res[i] = random.ints(N_NUMBER_PER_GROUP, Integer.MIN_VALUE, Integer.MAX_VALUE).toArray();
        }
        return res;
    }
}
