package dsa.recursion;

public class NBitBinaryNumbers {
    //https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1

    //Given a positive integer n. Your task is to generate a string list of
    // all n-bit binary numbers where, for any prefix of the number,
    // there are more or an equal number of 1's than 0's.
    // The numbers should be sorted in decreasing order of magnitude.

    public static void main(String[] args) {
        generateBinaryNumbers(3, 0, 0, "");
    }

    private static void generateBinaryNumbers(int n, int zeros, int ones, String output) {
        if (n == 0) {
            System.out.println(output);
            return;
        }
        if (ones > zeros)
            generateBinaryNumbers(n - 1, zeros + 1, ones, output + "0");
        generateBinaryNumbers(n - 1, zeros, ones + 1, output + "1");
    }
}
