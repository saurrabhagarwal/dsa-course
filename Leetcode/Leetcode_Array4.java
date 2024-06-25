package dsa.Leetcode;

import java.util.List;

public class Leetcode_Array4 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(differenceOfSum(new int[]{1, 15, 6, 3}));
        System.out.println(arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
        System.out.println(arithmeticTriplets2(new int[]{0, 1, 4, 6, 7, 10}, 3));
    }

    //https://leetcode.com/problems/number-of-arithmetic-triplets/
    public static int arithmeticTriplets(int[] nums, int diff) {
        //0,1,4,6,7,10
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        System.out.println("triplet " + i + j + k);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int arithmeticTriplets2(int[] nums, int diff) {
        //0,1,4,6,7,10
        int n = nums.length;
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }
        boolean[] arr = new boolean[max +diff+diff+ 1];
        for (int num : nums) {
            arr[num] = true;
        }
        for (int num : nums) {
            if (arr[num + diff] && arr[num + diff + diff])
                count++;
        }
        return count;
    }

    //https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/
    public static int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;
        for (int j : nums) {
            sum += j;
            int num = j;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }
        return Math.abs(sum - digitSum);
    }

    //https://leetcode.com/problems/shuffle-string/
    public static String restoreString(String s, int[] indices) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return String.valueOf(arr);
    }

    //https://leetcode.com/problems/count-items-matching-a-rule/
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        //type,color,name
        int i = ruleKey.charAt(0) == 't' ? 0 : ruleKey.charAt(0) == 'c' ? 1 : 2;
        int count = 0;
        for (List<String> item : items) {
            if (item.get(i).equals(ruleValue)) count++;
        }
        return count;

    }

    //https://leetcode.com/problems/truncate-sentence/
    public static String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
            }
            if (k == 0) s = s.substring(0, i);
        }
        return s;
    }

    //https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int x = 0, y = 0;
        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(x) != word2[i].charAt(y)) return false;
            x++;
            y++;
            if (x == word1[i].length()) {
                x = 0;
                i++;
            }
            if (y == word2[j].length()) {
                y = 0;
                j++;
            }

        }
        return i == word1.length && j == word2.length;
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String s : word1)
            s1.append(s);
        for (String s : word2)
            s2.append(s);
        return s1.toString().equals(s2.toString());
    }
}
