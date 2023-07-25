import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Truck extends Thread
{
    private static long elev1 = 0;
    private static long elev2 = 0;

    int load;
    int nLoads;
    static final ReentrantReadWriteLock lock;
    static final Lock readLock;
    static final Lock writeLock;
    static {
        lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    public Truck(int load, int nLoads)
    {
        super();
        this.load = load;
        this.nLoads = nLoads;
    }

    public static long getElev1()
    {
        readLock.lock();
        try {
            return elev1;
        } finally {
            readLock.unlock();
        }
    }

    public static long getElev2()
    {
        readLock.lock();
        try {
            return elev2;
        } finally {
            readLock.unlock();
        }
    }

    public void run()
    {
        for(int i=0; i<nLoads; i++)
        {
            loadElev1(load);
            loadElev2(load);
        }
    }

    private void loadElev2(int load)
    {
        writeLock.lock();
        try {
            elev2 += load;
        } finally {
            writeLock.unlock();
        }
    }

    private void loadElev1(int load)
    {
        writeLock.lock();
        try {
            elev1 += load;
        } finally {
            writeLock.unlock();
        }
    }

}
