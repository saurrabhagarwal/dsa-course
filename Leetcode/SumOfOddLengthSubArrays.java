package dsa.Leetcode;

public class SumOfOddLengthSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubArrays(arr));
        System.out.println(sumOddLengthSubArrays2(arr));
        System.out.println(sumOddLengthSubArrays2(new int[]{1, 2}));
    }

    public static int sumOddLengthSubArrays(int[] arr) {
        int ans = 0;
        int n = arr.length;

        for (int i = 1; i <= n; i += 2) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < i && j + i - 1 < n; k++) {
                    ans += arr[j + k];
                }
            }
        }

        return ans;
    }

    public static int sumOddLengthSubArrays2(int[] arr) {
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //ans += arr[i] * (((i+1)*(n-i)+1)/2);
            int start = n - i;
            int end = i + 1;
            int total = start * end;
            int odd = total / 2;
            if (total % 2 == 1)
                odd++;
            ans += odd * arr[i];
        }
        return ans;
    }
}
