package dsa.recursion;

public class R2 {
    public static void main(String[] args) {
        //factorial of a number using recursion

        System.out.println(fact(5));
        //0->1
        //n-> f(n-1)*n
    }

    static int fact(int n) {
        if (n > 0) {
            return fact(n - 1) * n;
        }
        return 1;
    }
}
