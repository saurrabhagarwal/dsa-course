package dsa.Lrrtcode;

public class CountConsistentStrings {
    public static void main(String[] args) {
        //https://leetcode.com/problems/count-the-number-of-consistent-strings/
        //count array of string
        System.out.println(getCountConsistentStrings2(new String[]{"ad", "bd", "aaab", "baa", "badab"}, "ab"));
        //bit manipulation
        System.out.println(getCountConsistentStrings(new String[]{"ad", "bd", "aaab", "baa", "badab"}, "ab"));
    }

    public static int getCountConsistentStrings(String[] strings, String allowed) {
        int ans = 0;
        int a = binaryForm(allowed);
        for (String s : strings) {
            if ((a | binaryForm(s)) == a) ans++;
        }
        return ans;
    }

    public static int binaryForm(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans |= 1 << c - 'a'; //mask and merge
        }
        return ans;
    }

    public static int getCountConsistentStrings2(String[] strings, String allowed) {
        int ans = 0;
        boolean[] ca = new boolean[26];
        for (char c : allowed.toCharArray()) {
            ca[c-'a'] = true;
        }
        for (String s : strings) {
            boolean ok = true;
            for (char c : s.toCharArray()) {
                if (!ca[c-'a']) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans++;
        }
        return ans;
    }
}
