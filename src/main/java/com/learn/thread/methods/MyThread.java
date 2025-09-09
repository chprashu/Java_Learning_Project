package com.learn.thread.methods;

/**
 * implementation of custom thread by extending Thread
 */
public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Hello World...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " is interrupted with the state: "
                    + Thread.currentThread().getState());
            ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        MyThread t1 = new MyThread("MyThread");
        System.out.println(t1.getName() + " state: " + t1.getState());
        t1.start();
        System.out.println(t1.getName() + " state: " + t1.getState()); // RUNNABLE

        /*
         * if we prioritize the thread which is taking time to execute something
         * then state TIMED_WAITING will be assigned to the Thread
         */
        Thread.sleep(100);
        System.out.println(t1.getName() + " state: " + t1.getState()); // TIMED_WAITING

        /*
         * join() method waits the thread to die after, after thread died
         * method will allow below lines to execute
         */
        t1.join();
        System.out.println(t1.getName() + " state: " + t1.getState()); // TERMINATED

        MyThread thread = new MyThread("CustomThread");
        thread.start();
        /** if thread is in sleep we interrupt using interrupt() */
        thread.interrupt();
        System.out.println(t1.getName() + " state: " + thread.getState());
    }
}
