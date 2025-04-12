package dsa.Questions;

import java.util.ArrayList;
import java.util.List;

public class PrimeTest {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            if (isPrime(i))
                System.out.println(i + " is a prime number");
            else
                System.out.println(i + " is not a prime number");
        }

        findFactors(36);

        System.out.println();
        findFactors(35);
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static void findFactors(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i + "," + n / i);
                if (n / i != i)
                    System.out.println(n / i + "," + i);
            }

        }
    }
}
