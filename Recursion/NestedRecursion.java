package dsa.recursion;

public class NestedRecursion {
    public static void main(String[] args) {
        System.out.println(fun(95));
        //95 96
    }

    static int fun(int n) {
        System.out.println(n);
        if (n > 100)
            return n - 10;
        else
            return fun(fun(n + 11));
    }
}
