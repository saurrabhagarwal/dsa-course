package dsa.recursion;

public class R3 {
    public static void main(String[] args) {
        //power using recursion

        System.out.println(power(2, 10));
        System.out.println(power2(2, 10));
        //0->1
        //n->m*m.power(n-1)
    }

    static int power(int m, int n) {
        if (n == 0)
            return 1;
        return m * power(m, n - 1);
    }

    //efficient method

    static int power2(int m, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 0)
            return power2(m * m, n / 2);
        else
            return m * power2(m * m, (n - 1) / 2);
    }
}
