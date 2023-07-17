import java.util.Random;

public class Truck extends Thread
{
    private static long elev1 = 0;
    private static long elev2 = 0;
    private static final Object mutex = new Object();

    int load;
    int nLoads;

    public Truck(int load, int nLoads)
    {
        super();
        this.load = load;
        this.nLoads = nLoads;
    }

    public static long getElev1()
    {
        return elev1;
    }

    public static long getElev2()
    {
        return elev2;
    }

    public void run()
    {
        for(int i=0; i<nLoads; i++)
        {
            loadElev1();
            loadElev2();
        }
    }

    private void loadElev2() {
        synchronized (mutex) {
            elev2 += load;
        }
    }

    private void loadElev1() {
        synchronized (mutex) {
            elev1 += load;
        }
    }
}
