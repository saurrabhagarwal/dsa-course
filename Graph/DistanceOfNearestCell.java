package dsa.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {
    private static class Pair {
        int first;
        int second;
        int third;

        public Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] res = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            int dist = p.third;

            res[row][col] = dist;
            //find neighbours
//            if (i - 1 >= 0 && !vis[i - 1][j]) {
//                q.add(new Pair(i - 1, j, dist + 1));
//                vis[i - 1][j] = true;
//            }
//            if (i + 1 < n && grid[i + 1][j] == 1 && !vis[i + 1][j]) {
//                q.add(new Pair(i + 1, j, dist + 1));
//                vis[i + 1][j] = true;
//            }
//            for (int k = j - 1; k <= j + 1; k++) {
//                if (k >= 0 && k < m && !vis[i][k]) {
//                    q.add(new Pair(i, k, dist + 1));
//                    vis[i][k] = true;
//                }
//            }

            int delrow[] = {-1, 0, +1, 0};
            int delcol[] = {0, +1, 0, -1};
            // for all 4 neighbours
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                // check for valid unvisited cell
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol, dist + 1));
                }
            }
        }
        System.out.println(Arrays.deepToString(res));
    }
}
