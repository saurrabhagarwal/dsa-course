package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_Array1 {
    //https://leetcode.com/problems/largest-local-values-in-a-matrix/


    public static void main(String[] args) {
        int[][] grid = new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        System.out.println(Arrays.deepToString(largestLocal(grid)));

        int[][] accounts = new int[][]{{1, 2, 23}, {13, 2, 1}};
        System.out.println(" max " + maximumWealth(accounts));
        subsetOfArray();

        List<Integer> arr = List.of(5, 1, 6);
        List<List<Integer>> res = subsets(arr);
        System.out.println(res);

        System.out.println(powerOfTwo(14));
        System.out.println(powerOfTwo(16));

        System.out.println(minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}));

    }

    public static int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                for (int x = i; x <= i + 2; x++) {
                    for (int y = j; y <= j + 2; y++) {
                        ans[i][j] = Math.max(grid[x][y], ans[i][j]);
                    }
                }
            }
        }
        return ans;
    }

    //https://leetcode.com/problems/richest-customer-wealth/description/
    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            max = Math.max(max, wealth);
        }
        return max;
    }

    //https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
    public static void subsetOfArray() {
        int[] arr = new int[]{5, 1, 6};
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < (1 << n); i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    s ^= arr[j];
                }
            }
            total += s;
        }
        System.out.println(total);
    }

    public static List<List<Integer>> subsets(List<Integer> arr) {

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        int index = 0;
        calcSubset(arr, res, subset, index);
        return res;
    }

    private static void calcSubset(List<Integer> arr, List<List<Integer>> res, List<Integer> subset, int index) {
        // Add the current subset to the result list
        System.out.println(subset);
        res.add(new ArrayList<>(subset));

        // Generate subsets by recursively including and
        // excluding elements
        for (int i = index; i < arr.size(); i++) {
            // Include the current element in the subset
            subset.add(arr.get(i));

            // Recursively generate subsets with the current
            // element included
            calcSubset(arr, res, subset, i + 1);

            // Exclude the current element from the subset
            // (backtracking)
            subset.remove(subset.size() - 1);

        }
    }

    public static boolean powerOfTwo(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        return num == 1;
    }

    //bit manipulation
    static boolean isPowerOfTwo(int x) {
        /* First x in the below expression is
          for the case when x is 0 */
        //If we subtract a power of 2 numbers by 1 then all unset bits after the only set bit become set; and the set bit becomes unset.
        //For example for 4 ( 100) and 16(10000), we get the following after subtracting 1
        //3 –> 011
        //15 –> 01111
        //
        //So, if a number n is a power of 2 then bitwise & of n and n-1 will be zero. We can say n is a power of 2 or not based on the value of n&(n-1). The expression n&(n-1) will not work when n is 0. To handle this case also, our expression will become n& (!n&(n-1))
        return x != 0 && ((x & (x - 1)) == 0);
    }

    //https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
    public static int minMovesToSeat(int[] seats, int[] students) {
//        sortArray(seats);
//        Arrays.sort(students);
//        int sum =0;
//        for (int i = 0; i < seats.length; i++) {
//            sum += Math.abs(students[i]-seats[i]);
//        }
//        return sum;
        int max = 0;
        for (int s : seats) {
            if (s > max) max = s;
        }
        for (int s : students) {
            if (s > max) max = s;
        }
        int[] pos = new int[max+1];
        int n = seats.length;
        for (int i = 0; i < n; i++) {
            pos[seats[i]]++;
            pos[students[i]]--;
        }
        int res = 0;
        int current = 0;
        for (int i : pos) {
            res += Math.abs(current);
            current += i;
        }
        return res;
    }

    private static int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }


}
