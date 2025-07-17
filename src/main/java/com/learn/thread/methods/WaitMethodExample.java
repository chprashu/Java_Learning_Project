package com.learn.thread.methods;

public class WaitMethodExample {

    private Integer value;
    private Boolean available = false;

    public void produce(int value) throws InterruptedException {
        synchronized (this) {
            while (available) {
                wait();
            }

            this.value = value;
            System.out.println(Thread.currentThread().getName() + " Producing a value: " + value);
            this.available = true;
            notify();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (!available) {
                wait();
            }

            System.out.println(Thread.currentThread().getName() + " is consuming the value: " + this.value);
            this.available = false;
            notify();
        }
    }

    public static void main(String[] args) {

        WaitMethodExample example = new WaitMethodExample();

        Thread t1 = new Thread(new Produce(example));
        Thread t2 = new Thread(new Consumer(example));
        Thread t3 = new Thread(new Consumer(example));

        t1.start();
        t2.start();
        t3.start();
    }

}

class Produce implements Runnable {

    private WaitMethodExample example;

    public Produce(WaitMethodExample example) {
        this.example = example;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                example.produce(i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private WaitMethodExample example;

    public Consumer(WaitMethodExample example) {
        this.example = example;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                example.consume();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}