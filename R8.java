package dsa.recursion;

public class R8 {
    public static void main(String[] args) {
        //hanoi tower using recursion

        TOH(3, 1, 2, 3);
        System.out.println(fun(5));
    }

    static void TOH(int disk, int A, int B, int C) {
        if (disk > 0) {
            TOH(disk - 1, A, C, B);
            System.out.println("moving disk-" + disk + " from tower-" + A + " to tower-" + C);
            TOH(disk - 1, B, A, C);
        }
    }

    static int fun(int n) {

        int x = 1, k;

        if (n == 1) return x;

        for (k = 1; k < n; ++k) {

            x = x + fun(k) * fun(n - k);
        }
        return x;

    }
}
