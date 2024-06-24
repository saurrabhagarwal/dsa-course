package dsa.Lrrtcode;

public class Q3158 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/

        System.out.println(duplicateNumbersXOR(new int[]{1, 2, 2, 1}));
    }

    public static int duplicateNumbersXOR(int[] nums) {
        int[] cnt = new int[51];
        for (int num : nums) {
            cnt[num]++;
        }
        int ans = 0;
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == 2) {
                ans ^= i;
            }
        }
        return ans;
    }
}
