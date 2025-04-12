package dsa.javaCourse;

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("T1 running on " + Thread.currentThread().getName());
        }
    }
}

class Thread2 implements Runnable {
    int count = 1;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("T2 running on " + Thread.currentThread().getName());
            System.out.println(count++);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
class Thread3 implements Runnable {
    int count = 1;

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("T3 running on " + Thread.currentThread().getName());
            System.out.println(count++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ThreadLearn {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        System.out.println(t1.getPriority());
        Thread t2 = new Thread(new Thread2());
        t1.run(); //main thread
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getPriority());
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        // t2.setDaemon(true);
        t2.start(); //thread t2
        t2.interrupt(); //sleep interrupted
        System.out.println("Main thread completed");

        Thread t3 = new Thread(new Thread3());
        t3.setDaemon(true);
        t3.setName("Thread 3");
        t3.start();

        Thread main =Thread.currentThread();
        main.join();
        Thread.yield();//it will give some time to other thread to run
    }
}
