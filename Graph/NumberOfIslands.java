package dsa.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 1, 0}};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!vis[row][col] && grid[row][col] == 1) {
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        System.out.println("count " + count);
    }

    private static void bfs(int row, int col, boolean[][] vis, int[][] grid) {
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int r = pair.first;
            int c = pair.second;

            //-1,0,-1 for neighbours
            // traverse neighbours and check if that is not visited and is land
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nR = r + i;
                    int nC = c + j;
                    if (nR >= 0 && nR < n && nC >= 0 && nC < m && grid[nR][nC] == 1 && !vis[nR][nC]) {
                        vis[nR][nC] = true;
                        q.add(new Pair(nR, nC));
                    }
                }
            }
        }
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
