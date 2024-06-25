package dsa.Leetcode;

import java.util.Arrays;

public class FindIntersectionValues {
    //https://leetcode.com/problems/find-common-elements-between-two-arrays/description/

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 3, 1};
        int[] nums2 = {2, 2, 5, 2, 3, 6};

        System.out.println(Arrays.toString(findIntersectionValues(nums1, nums2)));
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] ca1 = new boolean[101];
        boolean[] ca2 = new boolean[101];

        for (int num : nums1) {
            ca1[num] = true;
        }
        for (int num : nums2) {
            ca2[num] = true;
        }
        int ans1 = 0;
        int ans2 = 0;
        for (int num : nums1) {
            if (ca2[num])
                ans1++;
        }
        for (int num : nums2) {
            if (ca1[num])
                ans2++;
        }
        return new int[]{ans1, ans2};
    }
}
