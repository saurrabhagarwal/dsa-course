package dsa;

import dsa.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode_Array2 {
    public static void main(String[] args) {
        System.out.println(maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
        List<Integer> nums = new ArrayList<>(List.of(-6, 2, 5, -2, -7, -1, 3));
        System.out.println(countPairs2(nums, -2));
        System.out.println(countPairs(nums, -2));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent2(new int[]{8, 1, 2, 2, 3})));
    }


    //https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] < nums[i]) count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        //[4, 0, 1, 1, 3]
        //[8, 1, 2, 2, 3]
        //[0, 0, 1, 2, 1, 0, 0, 0, 0, 1]
        //[0, 0, 1, 3, 4, 4, 4, 4, 4, 5]
        //[4, 0, 1, 1, 3]
        int max = 0;
        for (int x : nums) {
            if (x > max) max = x;
        }
        int[] cnt = new int[max + 2];
        for (int x : nums) {
            ++cnt[x + 1];
        }
        for (int i = 1; i < cnt.length; ++i) {
            cnt[i] += cnt[i - 1];
        }
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = cnt[nums[i]];
        }
        return ans;
    }

    //https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
    public static int countPairs2(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) < target) {
                count += (j - i);
                i++;
            } else j--;
        }
        return count;
    }

    public static int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) count++;
            }
        }
        return count;
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int maxDiff = x[1] - x[0];
        for (int i = 2; i < x.length - 1; i++) {
            int diff = x[i + 1] - x[i];
            if (diff > maxDiff) maxDiff = diff;
        }
        return maxDiff;
    }


}
