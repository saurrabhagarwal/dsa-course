package dsa.javaCourse;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

interface MethodRef {
    void showMessage(String s);
}

interface MethodRef2 {
    int compare(String s1, String s2);
}

public class MethodRefLearn {
    public static void main(String[] args) throws Exception {
        MethodRef methodRef = (s) -> System.out.println(s);
        methodRef.showMessage("Hello World");

        //Static method ref
        MethodRef methodRef1 = MethodRefLearn::reverse;
        methodRef1.showMessage("Hello World");

        //non-static method ref
        MethodRefLearn methodRefLearn = new MethodRefLearn("");
        MethodRef methodRef2 = methodRefLearn::uppercase;
        methodRef2.showMessage("Hello World");

        //constructor method ref
        MethodRef methodRef3 = MethodRefLearn::new;
        methodRef3.showMessage("Hello");

        MethodRef2 ref2 = String::compareTo;
        System.out.println(ref2.compare("Hello", "Hello"));

    }

    public static void reverse(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        System.out.println(sb);
    }

    public void uppercase(String s) {
        System.out.println(s.toUpperCase(Locale.ROOT));
    }

    public MethodRefLearn(String s) {
        System.out.println(s);
    }
}
