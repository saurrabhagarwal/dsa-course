package dsa.javaCourse;

import java.io.RandomAccessFile;

public class RandomAccessLearn {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("JavaLearn/Random.txt","rw");
        System.out.println((char)randomAccessFile.read());
        System.out.println((char)randomAccessFile.read());
        System.out.println((char)randomAccessFile.read());
        randomAccessFile.write('D');
        randomAccessFile.seek(0);
        System.out.println((char)randomAccessFile.read());
        System.out.println((char)randomAccessFile.read());
        System.out.println((char)randomAccessFile.read());
        System.out.println((char)randomAccessFile.read());
    }
}
