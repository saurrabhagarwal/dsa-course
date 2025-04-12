package dsa.javaCourse;

import java.util.Objects;
import java.util.SortedMap;

public class MultiThreadLearn3 {
    public static void main(String[] args) {
        Whiteboard whiteboard = new Whiteboard();
        Teacher  teacher = new Teacher(whiteboard);
        Student11 student1 = new Student11(whiteboard,"A");
        Student11 student2 = new Student11(whiteboard,"B");
        Student11 student3 = new Student11(whiteboard,"C");
        Student11 student4 = new Student11(whiteboard,"D");
        teacher.start();
        student1.start();
        student2.start();
        student3.start();
        student4.start();
    }
}

class Whiteboard {
    String text;
    int students = 0;
    int count = 0;

    public void attendance() {
        students++;
        System.out.println("Attendance for Student " + students);
    }

    synchronized public void write(String t) throws InterruptedException {
        while (count != 0)
            wait();
        System.out.println("Teacher is writing " + t);
        text = t;
        count = students;
        notifyAll();
    }

    synchronized public String read() throws InterruptedException {
        while (count == 0)
            wait();
        String t = text;
        count--;
        if (count == 0)
            notify();
        return t;
    }
}

class Teacher extends Thread {
    Whiteboard wb;

    public Teacher(Whiteboard wb) {
        this.wb = wb;
    }

    String[] notes = {"Java first", "Spring next", "System Design Next", "DSA Next", "END"};

    @Override
    public void run() {
        for (String note : notes) {
            try {
                wb.write(note);
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Student11 extends Thread {
    Whiteboard wb;
    String name;

    public Student11(Whiteboard wb, String name) {
        this.wb = wb;
        this.name = name;
        wb.attendance();
    }


    @Override
    public void run() {
        String text;
        do {
            try {
                text = wb.read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Student " + name + " is reading " + text);
                System.out.flush();
        } while (!text.equals("END"));

    }
}