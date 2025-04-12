package dsa.javaCourse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SerializationLearn2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("data_streams.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        Student student = new Student(1,"John","CSE");
        dos.writeInt(student.rollNo);
        dos.writeUTF(student.name);
        dos.writeUTF(student.dept);

        FileInputStream fis = new FileInputStream("data_streams.txt");
        DataInputStream dis = new DataInputStream(fis);
        Student s =new Student(dis.readInt(), dis.readUTF(), dis.readUTF());
        System.out.println(s);
    }
}
