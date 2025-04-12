package dsa.javaCourse;

class MyData2 {
    int value;
    boolean flag = true;

    synchronized public int getValue() throws InterruptedException {
        while (flag)
            wait();
        int x = value;
        flag = true;
        notify();
        return x;
    }

    synchronized public void setValue(int value) throws InterruptedException {
        while (!flag)
            wait();
        this.value = value;
        flag = false;
        notify();
    }
}

class Producer2 extends Thread {
    MyData2 d;

    public Producer2(MyData2 d) {
        this.d = d;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                System.out.println("Producer " + i);
                d.setValue(i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}

class Consumer2 extends Thread {
    MyData2 d;

    public Consumer2(MyData2 d) {
        this.d = d;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer " + d.getValue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class MultiThreadLearn2 {
    public static void main(String[] args) {
        MyData2 d = new MyData2();
        Producer2 thread1 = new Producer2(d);
        Consumer2 thread2 = new Consumer2(d);
        thread2.start();
        thread1.start();

    }
}
