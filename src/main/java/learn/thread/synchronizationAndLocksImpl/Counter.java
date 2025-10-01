package learn.thread.synchronizationAndLocksImpl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private Integer count = 0;

    public Integer getCount() {
        return this.count;
    }

    /*
     * If two different threads are accessing the same variable parallely
     * means both will get the same count value and increment that value
     * eg. count = 5 in memeory 5 is stored
     * when both therads access the same value 5, and increment means both threads
     * will print same value as 6.
     * 
     * if any set of code behaves correctly as expected, when mutiple threds are
     * accessed then it is called thread safe.
     * 
     * if we consider below method as example.
     * if we try to access incerement() 1000 times by adding 1000 lines or through
     * for loop
     * or through threads our expected output should be count = 1000
     * 
     * but when we have multiple threads accessing this method parallely more than
     * once thread
     * can access same value from the memory, this will leads race condition since
     * two thread are updating same value.
     * 
     * to make increment() thread safe we have to use either synchronized keyword or
     * locks
     */
    public void increment() {
        this.count++;
    }

    /*
     * Making method thread Safe using synchronized
     */
    public synchronized void incerementSynchronously() {
        this.count++;
    }

    /*
     * Making a method thread safe using locs
     */
    Lock lock = new ReentrantLock();

    public void incerementUsingLock() {
        lock.lock();
        try {
            this.count++;
        } finally {
            lock.unlock();
        }
    }

    public static final int loopTimes = 1000;

    public static void main(String[] args) {

        Counter counter1 = new Counter();

        Runnable nonThreadSafe = () -> {
            for (int i = 0; i < loopTimes; i++) {
                counter1.increment();
            }
        };
        Thread thread1 = new Thread(nonThreadSafe);
        Thread thread2 = new Thread(nonThreadSafe);
        Thread thread3 = new Thread(nonThreadSafe);

        System.out.println("Non Thread safe execution started");
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println(counter1.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
        }
        System.out.println("Non Thread safe execution ended");
        System.out.println();

        Counter counter2 = new Counter();
        Runnable threadSafeBySynchronized = () -> {
            for (int i = 0; i < loopTimes; i++) {
                counter2.incerementSynchronously();
            }
        };
        thread1 = new Thread(threadSafeBySynchronized);
        thread2 = new Thread(threadSafeBySynchronized);
        thread3 = new Thread(threadSafeBySynchronized);
        System.out.println("Thread safe with synchronized execution started");
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println(counter2.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
        }
        System.out.println("Thread safe with synchronized execution ended");
        System.out.println();

        Counter counter3 = new Counter();
        Runnable threadSafeByLocks = () -> {
            for (int i = 0; i < loopTimes; i++) {
                counter3.incerementUsingLock();
            }
        };
        thread1 = new Thread(threadSafeByLocks);
        thread2 = new Thread(threadSafeByLocks);
        thread3 = new Thread(threadSafeByLocks);
        System.out.println("Thread safe with locks execution started");
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println(counter3.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
        }
        System.out.println("Thread safe with locks execution ended");
        System.out.println();
    }

}
