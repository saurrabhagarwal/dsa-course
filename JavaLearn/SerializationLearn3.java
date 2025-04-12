package dsa.javaCourse;

import java.io.*;

public class SerializationLearn3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("object_stream.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        Student s = new Student(10, "John", "CSE");
        os.writeObject(s);

        FileInputStream fis = new FileInputStream("object_stream.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student = (Student) ois.readObject();
        System.out.println(student);

        //test
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        DataOutputStream dos = new DataOutputStream(fileOutputStream);
        float[] numbers = new float[]{1.4f,1.5f,1.6f,6};
        dos.writeInt(numbers.length);
        for (float number : numbers) {
            dos.writeFloat(number);
        }
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        DataInputStream dis = new DataInputStream(fileInputStream);
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            System.out.println(dis.readFloat());
        }

    }
}
