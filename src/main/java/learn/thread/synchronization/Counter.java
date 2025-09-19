package learn.thread.synchronization;

public class Counter {

    private Integer count = 0;

    public Integer getCount() {
        return this.count;
    }

    public void increment() {
        this.count++;
    }
}
