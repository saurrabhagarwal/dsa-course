package dsa.javaCourse;

import java.util.Random;

public class ObjectLearn {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf(10);
        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);
        //true
        //true
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1.equals(o2));
        System.out.println(o1 == o2);
        //false
        //false

        String s1 = new String("ABC");
        String s2 = new String("ABC");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        //true
        //false

        float f1 = 10.2f;
        Float f2 = 10.2F;
        System.out.println(f2.equals(f1));
        System.out.println(f1 == f2);

        System.out.println(Math.abs(123));
        System.out.println(Math.absExact(-123));
        System.out.println(Math.cbrt(9));
        System.out.println(Math.cbrt(8));
        System.out.println(Math.sqrt(4));
        System.out.println(Math.sqrt(5));
        System.out.println(Math.decrementExact(10));
        System.out.println(Math.getExponent(12.3456));
        System.out.println(Math.random());
        System.out.println(Math.subtractExact(10,2));
    }
}
