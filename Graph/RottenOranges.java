package dsa.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private static class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        //{{2,2,0,1}}   -1
        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int max = 0;
        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                } else
                    vis[i][j] = false;
                if (grid[i][j] == 1) cntFresh++;
            }
        }

        int time = 0;
        int countR = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;
            time = Math.max(time, p.time);
            //find neighbours
            if (i - 1 >= 0 && grid[i - 1][j] == 1 && !vis[i - 1][j]) {
                q.add(new Pair(i - 1, j, time + 1));
                vis[i - 1][j] = true;
                countR++;
            }
            if (i + 1 < n && grid[i + 1][j] == 1 && !vis[i + 1][j]) {
                q.add(new Pair(i + 1, j, time + 1));
                vis[i + 1][j] = true;
                countR++;
            }
            for (int k = j - 1; k <= j + 1; k++) {
                if (k >= 0 && k < n && grid[i][k] == 1 && !vis[i][k]) {
                    q.add(new Pair(i, k, time + 1));
                    vis[i][k] = true;
                    countR++;
                }
            }
        }
        if (countR != cntFresh) {

            System.out.println(-1);
            return;
        }
        System.out.println(time);
    }
}
