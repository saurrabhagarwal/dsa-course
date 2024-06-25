package dsa.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctSubarraysSum {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 1);
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean[] ca = new boolean[101];
            int count = 0;
            for (int j = i; j < n; j++) {
                if (!ca[nums.get(j)]) {
                    count++;
                    ca[nums.get(j)] = true;
                }
                ans += count * count;
            }
        }
        System.out.println(ans);
    }
}
