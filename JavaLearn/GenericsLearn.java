package dsa.javaCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsLearn<T> {
    T[] t = (T[]) new Object[3];

    public static void main(String[] args) {
        Object obj = "Hello";
        String s = (String) obj;
        System.out.println(s);
        obj = 10;
        // s= (String) obj;
        //class java.lang.Integer cannot be cast to class java.lang.String
        System.out.println(s);

        GenericsLearn<String> gl = new GenericsLearn<>();
        gl.t = new String[]{"As", "d", "dd", "sas"};
        //gl.t[0]=10;
        //compile time error
        System.out.println(Arrays.toString(gl.t));

        String s1 = gl.t[0]; //no type cast required
        System.out.println(s1);

        Data<String> d = new Data<>();
        d.setData("Hello");
        System.out.println(d);

        DataArray<String> array = new DataArray<>();
        array.append("Hello");
        array.append("World");
        array.display();

        //Generic Methods
        show("Hello Gen Method");


        // List<Object> list = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<?> list = new ArrayList<String>();
        list = strings;
        System.out.println(list);
//        List<Object> objList = new ArrayList<String>();
//        objList.add(10);
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getState());
    }

    static <E> void show(E s) {
        System.out.println(s);
    }
}

class DataArray<T> {
    T[] arr = (T[]) new Object[10];

    int length = 0;

    void append(T t) {
        arr[length] = t;
        length++;
    }

    void display() {
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Data<T> {
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }
}
