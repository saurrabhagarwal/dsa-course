package dsa.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q2006 {
    public static void main(String[] args) {
        //2006. Count Number of Pairs With Absolute Difference K
        System.out.println(countKDifference(new int[]{1, 2, 1, 2}, 1));
        System.out.println(countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
        System.out.println(countKDifference2(new int[]{1, 2, 1, 2}, 1));
        System.out.println(countKDifference2(new int[]{3, 2, 1, 5, 4}, 2));
        System.out.println(countKDifference3(new int[]{1, 2, 1, 2}, 1));
        System.out.println(countKDifference3(new int[]{3, 2, 1, 5, 4}, 2));
    }

    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) count++;
            }
        }
        return count;
    }

    public static int countKDifference2(int[] nums, int k) {
        int count = 0;
        int[] countArray = new int[101];
        for (int num : nums) {
            countArray[num]++;
        }
        for (int i = 1; i < countArray.length - k; i++) {
            count += countArray[i] * countArray[i + k];
        }
        return count;
    }

    public static int countKDifference3(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums
        ) {
            count += map.getOrDefault(Math.abs(num + k), 0);
            count += map.getOrDefault(Math.abs(num - k), 0);
            map.put(num, map.getOrDefault(num,0)+1);
        }
        return count;
    }
    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            int i = 0;
            int j = word.length() - 1;
            boolean isPal = true;
            while (i < j) {
                if (word.charAt(i) != word.charAt(j)) {
                    isPal = false;
                    continue;
                } else{
                    i++;
                    j--;
                }
            }
            if (isPal) {
                return word;
            }
        }
        return "";
    }
}
