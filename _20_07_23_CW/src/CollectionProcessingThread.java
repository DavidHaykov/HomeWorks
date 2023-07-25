import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class CollectionProcessingThread extends Thread{
    private Collection<Integer> collection;
    private int nRuns;
    private int probUpdate;

    static final ReentrantReadWriteLock lock;
    static final Lock readLock;
    static final Lock writeLock;
    static {
        lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }
    public static AtomicLong countLocks = new AtomicLong();

    public CollectionProcessingThread(Collection<Integer> collection, int nRuns, int probUpdate) {
        this.collection = collection;
        this.nRuns = nRuns;
        this.probUpdate = probUpdate;
    }

    @Override
    public void run() {
        for(int i = 0; i < nRuns; i++){
            if(getRandomNumber(1,100) <= probUpdate){
                update();
            } else {
                read();
            }
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max-min+1) + min);
    }
    private void update(){
        try {
            tryDoLock(writeLock);
            int number = getRandomNumber(1, 100);
            collection.add(number);
            collection.remove(number);
        }
        finally {
            writeLock.unlock();
        }
    }
    private void read(){
        try {
            tryDoLock(readLock);
            for (Integer n : collection) {
                //do something
            }
        }
        finally {
            readLock.unlock();
        }
    }

    private void tryDoLock(Lock lock) {
        while(!lock.tryLock()){
            countLocks.getAndIncrement();
        }
    }
}
