package learn.thread.implRunnable;

public class TestIllegalThreadStateException {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread name: " + Thread.currentThread().getName() + " count: " + i);
            }
        });

        thread.start();
        thread.start(); // This will throw a RunTime Exception -> IllegalThreadStateException

    }
}
