package dsa.Lrrtcode;

import java.util.*;

public class Q760_Anagram_Mapping {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-anagram-mappings
        System.out.println(Arrays.toString(anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28})));
        //Output: [1,4,3,2,0]

    }

    public static int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; ++i) {
            map.computeIfAbsent(nums2[i], k -> new HashSet<>()).add(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            int idx = map.get(nums1[i]).iterator().next();
            res[i] = idx;
            map.get(nums1[i]).remove(idx);
        }
        return res;
    }
}
