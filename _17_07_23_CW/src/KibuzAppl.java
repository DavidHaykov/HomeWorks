import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class KibuzAppl
{
    private static final int N_TRUCKS = 1000;
    private static final int LOAD = 1;
    private static final int N_LOAD = 1000;

    public static void main(String[] args)
    {
        Truck[] trucks = new Truck[N_TRUCKS];
        for(int i=0; i<N_TRUCKS; i++)
        {
            trucks[i] = new Truck(LOAD, N_LOAD);
            trucks[i].start();
        }

        Instant start = Instant.now();
        for(Truck t: trucks)
        {
            try
            {
                t.join();
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.printf
                ("Running time is %d\nelevator1 contains %d tons\nelevator2 contains %d tons\n",
                        ChronoUnit.MILLIS.between(start, Instant.now()), Truck.getElev1(), Truck.getElev2());
    }

}
