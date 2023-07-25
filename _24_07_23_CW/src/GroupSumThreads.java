public class GroupSumThreads extends GroupSum{
    public GroupSumThreads(int[][] numbers) {
        super(numbers);
    }

    @Override
    public long computeSum() {
       OneGroupSum[] sums = new OneGroupSum[numbers.length];
       Thread[] threads = new Thread[numbers.length];
       for(int i = 0; i < numbers.length; i++){
           sums[i] = new OneGroupSum(numbers[i]);
           threads[i] = new Thread(sums[i]);
           threads[i].start();
       }
       long totalSum = 0;
       for(int i = 0; i < numbers.length; i++){
           try {
               threads[i].join();
               totalSum += sums[i].sum;
           }catch (InterruptedException ignored){

           }

       }
       return totalSum;
    }
}
