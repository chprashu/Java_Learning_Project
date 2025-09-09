package com.learn.thread.implRunnable;

public class MainClass {

    private static void addToList(PrintList printList) {
        for (int i = 0; i < 100000; i++) {
            printList.addToStrings(String.valueOf(i));
        }
    }

    public static void main(String[] args) {

        PrintList printList = new PrintList();

        Runnable t1Thread = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    printList.addToStrings(String.valueOf(i));
                }
            }
        };

        long startTime = System.nanoTime();
        Thread t1 = new Thread(t1Thread, "Thread1");
        Thread t2 = new Thread(t1Thread, "Thread2");
        Thread t3 = new Thread(t1Thread, "Thread3");
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(printList.getStrings());

        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 10_00_00.00);

        Runnable testThread1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority()
                            + " count:" + i);
                }
            }
        };

        Thread minPrioThread = new Thread(testThread1, "LOW");
        Thread normPrioThread = new Thread(testThread1, "MED");
        Thread maxPrioThread = new Thread(testThread1, "HIGH");
        minPrioThread.setPriority(Thread.MIN_PRIORITY);
        normPrioThread.setPriority(Thread.NORM_PRIORITY);
        maxPrioThread.setPriority(Thread.MAX_PRIORITY);
        minPrioThread.start();
        normPrioThread.start();
        maxPrioThread.start();
        try {
            minPrioThread.join();
            maxPrioThread.join();
            normPrioThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Runnable demonThread = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello World");
                }
            }
        };

        Thread demon = new Thread(demonThread, "DEMON");
        demon.setDaemon(true);
        demon.start();

        System.out.println(Thread.currentThread().getName() + " thread do something");

        System.out.println("DEMON Thread state: " + demon.getState());

    }
}
