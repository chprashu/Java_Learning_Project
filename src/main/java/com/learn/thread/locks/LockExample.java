package com.learn.thread.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    private final Lock lock = new ReentrantLock();

    private void outerMethod() {
        lock.lock();
        try {
            System.out.println("Running outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock();
        try {
            System.out.println("Running inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        LockExample lockExample = new LockExample();
        lockExample.outerMethod();
    }
}
