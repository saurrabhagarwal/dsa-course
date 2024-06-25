package dsa.Leetcode;

public class HighestAltitude {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-the-highest-altitude/submissions/1298497925/
        int[] gains = {-5, 1, 5, 0, -7};
        System.out.println(getHighestAltitude(gains));
        System.out.println(getHighestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }

    public static int getHighestAltitude(int[] gains) {
        int ans = 0;
        int alt = 0;
        for (int gain : gains) {
            alt += gain;
            ans = Math.max(alt,ans);
        }
        return ans;
    }
}
