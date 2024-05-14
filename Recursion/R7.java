package dsa.recursion;

public class R7 {
    public static void main(String[] args) {
        //nCr using recursion

        //nCr = (n-1Cr-1)+(n-1Cr)
        System.out.println(C(10, 5));
    }

    static int C(int n, int r) {
        if (n == r || r == 0)
            return 1;
        return C(n - 1, r - 1) + C(n - 1, r);
    }
}
