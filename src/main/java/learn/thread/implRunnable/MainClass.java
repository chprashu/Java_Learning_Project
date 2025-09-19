package learn.thread.implRunnable;

public class MainClass {

    public static void main(String[] args) {

        PrintList printList = new PrintList();

        /*
         * implementing Runnable with anonymous class by implementing single overridable
         * method
         */
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

        /*
         * implementing runnable with lambda, since runnable with have only one abstract
         * method (FunctionalInterface)
         */
        Runnable testThread1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority()
                        + " count:" + i);
            }
        };

        /*
         * Priority will help Operating system scheduler to set priority based execution
         * for the threads.
         * MIN_PRIORITY, 1
         * NORM_PRIORITY, 5
         * MAX_PRIORITY, 10
         */
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

        /*
         * A thread can be called as demon thread, only when it has an unfinished
         * process
         * eg, while(true) will never going to end its process
         * 
         * Since Runnable itself can be created using lambda we directly use it inside
         * new Thread as below described.
         */
        Thread demon = new Thread(() -> {
            while (true) {
                System.out.println("Hello World");
            }
        }, "DEMON");

        /*
         * Although it is having an unfinished process, thread should not kill itself.
         * if we set setDaemon(true) then Thread can be considered as Daemon Thread
         */
        demon.setDaemon(true);
        demon.start();

        System.out.println(Thread.currentThread().getName() + " thread do something");

        System.out.println("DEMON Thread state: " + demon.getState());

    }
}
