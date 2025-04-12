package dsa.javaCourse;

class MyData {
   synchronized void display(String s) {
        /*synchronized (this) {
            for (int i = 0; i < s.length(); i++) {
                System.out.println(s.charAt(i));
            }
        }*/

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}

class MyThread1 extends Thread {
    MyData d;

    public MyThread1(MyData d) {
        this.d = d;
    }

    @Override
    public void run() {
        d.display("Hello World");
    }
}

class MyThread2 extends Thread {
    MyData d;

    public MyThread2(MyData d) {
        this.d = d;
    }

    @Override
    public void run() {
        d.display("Welcome");
    }
}

public class MultiThreadLearn {
    public static void main(String[] args) {
        MyData d = new MyData();
        MyThread1 thread1 = new MyThread1(d);
        MyThread2 thread2 = new MyThread2(d);
        thread2.start();
        thread1.start();

    }
}
