package learn.thread.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private Integer balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withDraw(Integer amount) {
        try {
            /*
             * if(lock.tryLock()) tryLock() is used to is there any lock applied locked code
             * snippet or method
             */
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("withdrawing amount started, from Thread: " + Thread.currentThread().getName());
                if (balance >= amount) {
                    try {
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println("Available Balance: " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Insufficient Balance");
                }
            } else {
                System.out.println("try after some time...");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();

        Runnable bank = () -> sbi.withDraw(50);

        Thread t1 = new Thread(bank, "Thread1");
        Thread t2 = new Thread(bank, "Thread2");
        t1.start();
        t2.start();

    }
}
