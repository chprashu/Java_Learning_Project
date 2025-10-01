package learn.thread.synchronizationAndLocksImpl;

public class SyncThread extends Thread {

    private final Counter counter;

    public SyncThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        SyncThread count1 = new SyncThread(counter);
        SyncThread count2 = new SyncThread(counter);
        SyncThread count3 = new SyncThread(counter);
        count1.start();
        count2.start();
        count3.start();
        try {
            count1.join();
            count2.join();
            count3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCount());

    }
}
