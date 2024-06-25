package dsa.Leetcode;

public class DiagonalMatrixSum {
    //https://leetcode.com/problems/matrix-diagonal-sum/
    public static void main(String[] args) {
        System.out.println(diagonalSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(diagonalSum(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
        System.out.println(diagonalSum(new int[][]{{5}}));
    }

    public static int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1)
                    ans += mat[i][j];
            }

        }
        return ans;
    }

    public static int diagonalSum2(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            ans += mat[i][i]; //primary
            if (i != n - i - 1)
                ans += mat[i][n - i - 1]; //secondary
        }
        return ans;
    }
}
