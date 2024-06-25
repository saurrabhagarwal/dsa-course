package dsa.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_Array3 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 1, 5, 4};
        checkEquilibrium(arr);
        checkEquilibrium2(arr);
        System.out.println(sumIndicesWithKSetBits(arr, 2));
        System.out.println(Arrays.toString(leftRightDifference(new int[]{10, 4, 8, 3})));
        System.out.println(Arrays.toString(createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 1, 2, 3})));
        System.out.println(Arrays.toString(decompressRLElist2(new int[]{1, 1, 2, 3})));
    }

    //https://leetcode.com/problems/decompress-run-length-encoded-list/submissions/1291183198/
    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            int f = nums[2 * i];
            int v = nums[2 * i + 1];
            for (int j = 0; j < f; j++) {
                list.add(v);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }

    public static int[] decompressRLElist2(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i += 2) {
            n += nums[i];
        }
        int[] ans = new int[n];
        for (int i = 1, k = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i - 1]; j++) {
                ans[k++] = nums[i];
            }
        }
        return ans;
    }

    //https://leetcode.com/problems/create-target-array-in-the-given-order
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    //https://leetcode.com/problems/left-and-right-sum-differences/
    public static int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            ans[i] = Math.abs(total - leftSum);
            leftSum += nums[i];
        }
        return ans;
    }

    //https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/
    //Input: nums = [5,10,1,5,2], k = 1
    //Output: 13
    //Explanation: The binary representation of the indices are:
    //0 = 0002
    //1 = 0012
    //2 = 0102
    //3 = 0112
    //4 = 1002
    //Indices 1, 2, and 4 have k = 1 set bits in their binary representation.
    //Hence, the answer is nums[1] + nums[2] + nums[4] = 13.
    public static int sumIndicesWithKSetBits(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //Integer.bitCount(i)==k
            if (bitCount(i) == k)
                sum += nums[i];
        }
        return sum;
    }

    public static int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    //Problem Statement: Given an array of n integers, find if any index exists such that
    // the sum of elements to its right is equal to the sum of elements to its left.
    // If yes print the index, otherwise print “No Equilibrium”.

    public static void checkEquilibrium(int[] arr) {
        int[] pf = new int[arr.length];
        pf[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pf[i] = pf[i - 1] + arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            if (pf[i - 1] == pf[arr.length - 1] - pf[i]) {
                System.out.println("index " + i);
                return;
            }
        }
        System.out.println("No Equilibrium");
    }

    public static void checkEquilibrium2(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];
            if (leftSum == totalSum) {
                System.out.println("index " + i);
                return;
            }
            leftSum += arr[i];
        }
        System.out.println("No Equilibrium");
    }
}
