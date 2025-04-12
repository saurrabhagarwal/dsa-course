package dsa.javaCourse;

import java.io.*;

class Student implements Serializable{
    int rollNo;
    String name;
    String dept;

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }

    public Student(int rollNo, String name, String dept) {
        this.rollNo = rollNo;
        this.name = name;
        this.dept = dept;
    }
}
public class SerializationLearn1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("ser.txt");
        PrintStream ps = new PrintStream(fos);
        Student s = new Student(1,"John","CSE");
        ps.println(s.rollNo);
        ps.println(s.name);
        ps.println(s.dept);

        FileInputStream fis = new FileInputStream("ser.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        Student student = new Student(Integer.parseInt(br.readLine()), br.readLine(), br.readLine());
        System.out.println(student);
    }
}
