import java.lang.invoke.StringConcatException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageBox {
    private String message;
    Lock lock;
    Condition producesWaitingCondition;
    Condition comsumerWaitingCondition;

    public MessageBox() {
        this.lock = new ReentrantLock();
        this.producesWaitingCondition = lock.newCondition();
        this.comsumerWaitingCondition = lock.newCondition();
    }

    // for producer
    public void put(String message) {
        lock.lock();
        try {
            while (this.message != null) {
                try {
                    producesWaitingCondition.await();
                } catch (InterruptedException e) {
                }
            }
            this.message = message;
            comsumerWaitingCondition.signal();
        }
        finally {
            lock.unlock();
        }
    }

    // for consumer
    public String take() throws InterruptedException {
        lock.lock();
        try {
            while (this.message == null) {
                comsumerWaitingCondition.await();
            }
            String res = this.message;
            this.message = null;
            producesWaitingCondition.signal();
            return res;
        }finally {
            lock.unlock();
        }
    }

    public String pull() {
        lock.lock();
        try {
            String res = this.message;
            this.message = null;
            return res;
        } finally {
            lock.unlock();
        }
    }
}
