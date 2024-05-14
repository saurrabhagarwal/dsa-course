package dsa.recursion;

import java.util.Arrays;

public class R6 {
    static int[] f = new int[10];

    public static void main(String[] args) {
        //fibonacci series using recursion

        Arrays.fill(f, -1);
        for (int i = 0; i < 10; i++) {
//            System.out.println(fib(i));
//            System.out.println(loop(i));
            System.out.println(memo(i));
        }
    }

    static int fib(int n) {
        System.out.println("fib function called for " + n);
        if (n == 1 || n == 0)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    static int memo(int n) {
        if (f[n] != -1) {
            return f[n];
        }
        System.out.println("fib function called for " + n);
        if (n == 1 || n == 0) {
            f[n] = n;
            return f[n];
        }
        f[n] = memo(n - 1) + memo(n - 2);
        return f[n];
    }

    static int loop(int n) {
        int t0 = 0;
        int t1 = 1;
        int s = 0;
        if (n <= 1)
            return n;
        for (int i = 2; i <= n; i++) {
            s = t0 + t1;
            t0 = t1;
            t1 = s;
        }
        return s;
    }
}

