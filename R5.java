package dsa.recursion;

public class R5 {
    static double s = 1;

    public static void main(String[] args) {
        //Taylor's series using recursion - Horner's Rule
        System.out.println(e(1, 10));
        System.out.println(loop(1, 10));
        //n=0=>s
        //s =1  static variables
        //s= 1+(x/n)*s
        //n>0, e(x,n-1)
    }

    static double e(double x, double n) {
        if (n == 0) {
            return s;
        }
        s = 1 + (x / n) * s;
        return e(x, n - 1);
    }

    static double loop(double x, double n) {
        double s =1;
        for (double i = n; i > 0; i--) {
            s= 1+(x/i)*s;
        }
        return s;
    }
}
