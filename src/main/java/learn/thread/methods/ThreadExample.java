package learn.thread.methods;

import java.util.ArrayList;
import java.util.List;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>();

        long startTimeT = System.nanoTime();
        Thread t1 = new Thread(addToList(1, 350000, list));
        t1.start();
        Thread t2 = new Thread(addToList(350001, 700000, list));
        t2.start();
        Thread t3 = new Thread(addToList(700001, 1050000, list));
        t3.start();
        Thread t4 = new Thread(addToList(700001, 1050000, list));
        t4.start();
        Thread t5 = new Thread(addToList(700001, 1050000, list));
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        long endTimeT = System.nanoTime();
        System.out.println("Thread method: " + (endTimeT - startTimeT) / 1_000_000.0);

        // long startTime = System.nanoTime();
        // for(int i = 1; i <= 1050000; i++) {
        // String s = String.valueOf(i);
        // list.add(s);
        // }
        // long endTime = System.nanoTime();
        // System.out.println("Regular method: " + (endTime - startTime) / 1_000_000.0);

        // System.out.println(list.toString());

        // System.out.println(list.toString());

    }

    public static Runnable addToList(int from, int to, List<String> list) {

        Runnable t1 = new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = from; i <= to; i++) {
                    String s = String.valueOf(i);
                    list.add(s);
                }
            }
        };
        return t1;
    }
}
