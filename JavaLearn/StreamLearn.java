package dsa.javaCourse;

import java.io.*;
import java.util.Arrays;

public class StreamLearn {
    public static void main(String[] args) throws IOException {
        String s = "";
        System.out.println(Arrays.toString(s.getBytes()));
        byte b = 127;
        System.out.println(b);
        copyFile();
        mergeFile();
        byte[] bytes = {'a','b','c','d'};
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        String str = new String(bis.readAllBytes());
        System.out.println(str);
        System.out.println(bis.markSupported());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(bytes);
        bos.write('e');
        String out = bos.toString();
        System.out.println(out);
    }
    private static void copyFile() throws IOException {
        try (FileInputStream fis = new FileInputStream("JavaLearn/Source.txt");
             FileOutputStream fos = new FileOutputStream("Dest.txt")) {
            int b;
            while ((b = fis.read()) != -1) {
                if (b >= 'A' && b <= 'Z')
                    fos.write((char) b + 'a' - 'A');
                else
                    fos.write(b);
            }
        }
    }

    private static void mergeFile() throws IOException {
        try (FileInputStream fis1 = new FileInputStream("JavaLearn/Source.txt");
             FileInputStream fis2 = new FileInputStream("Dest.txt");
             FileOutputStream fos = new FileOutputStream("Merge.txt")) {
            int b;
            while ((b = fis1.read()) != -1) {
                fos.write(b);
            }
            while ((b = fis2.read()) != -1) {
                fos.write(b);
            }
        }
    }
}
