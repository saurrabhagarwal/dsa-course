package dsa.NEETCODE;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int[] out = new int[n];

        /*int[] prefix = new int[n];
        int[] postfix = new int[n];
        prefix[0] = arr[0];
        postfix[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = arr[i] * prefix[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * arr[i];
        }
        for (int i = 1; i < n -1; i++) {
            out[i] = prefix[i-1]*postfix[i+1];
        }
        out[0]= postfix[1];
        out[n -1]=prefix[n -2];
        System.out.println(Arrays.toString(out));*/

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            out[i] = prefix;
            prefix *= arr[i];
        }
        int postfix = 1;
        for (int i = n-1; i >=0 ; i--) {
            out[i]*= postfix;
            postfix *= arr[i];
        }
        System.out.println(Arrays.toString(out));
    }
}
