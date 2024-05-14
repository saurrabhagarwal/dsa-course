package dsa.recursion;

public class R1 {
    public static void main(String[] args) {
        //sum of first n natural  numbers using recursion

        System.out.println(fun(10));
    }

    static int fun(int n) {
        if (n > 0) {
            return fun(n - 1)+n;
        }
        return 0;
    }
}
