package dsa.javaCourse;

import java.io.*;

class Producer implements Runnable {
    OutputStream outputStream;

    public Producer(OutputStream os) {
        outputStream = os;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (true) {
                count++;
                System.out.println("Producer " + count);
                outputStream.write(count);
                outputStream.flush();
                System.out.flush();
                Thread.sleep(20);
            }
        } catch (Exception e) {
        }
    }
}

class Consumer implements Runnable {
    InputStream inputStream;

    public Consumer(InputStream is) {
        inputStream = is;
    }

    @Override
    public void run() {
        int x;
        try {
            while (true) {
                x = inputStream.read();
                System.out.println("Consumer " + x);
                System.out.flush();
                Thread.sleep(20);
            }
        } catch (Exception e) {
        }
    }
}

public class PipeLearn {
    public static void main(String[] args) throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);

        Producer producer = new Producer(pos);
        Consumer consumer = new Consumer(pis);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
