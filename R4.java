package dsa.recursion;

public class R4 {
    static double p = 1;
    static double f = 1;

    public static void main(String[] args) {
        //Taylor's series using recursion
        System.out.println(e(1, 10));
        System.out.println(loop(1, 10));
        //n=0=>1
        //p,f =1  static variables
        //p=p*x
        //f = f*n
        //n>0, (r+(p/f))

    }

    static double e(int x, int n) {
        if (n == 0) {
            return 1;

        }
        double r = e(x, n - 1);
        p = p * x;
        f = f * n;
        return r + (p / f);
    }

    static double loop(int x, int n) {
        double s = 1;
        double p = 1;
        double f = 1;
        for (int i = 1; i <= n; i++) {
            p = p * x;
            f = f * i;
            s = s + (p / f);
        }
        return s;
    }
}
