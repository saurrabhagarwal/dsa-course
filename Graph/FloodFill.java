package dsa.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        bfs(1, 1, 2, grid);
        System.out.println("after bfs");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        grid = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        dfs(new Pair(1,1),vis,grid);
        System.out.println("after dfs");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int r, int c, int color, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        vis[r][c] = true;
        int oldColor = grid[r][c];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        while (!q.isEmpty()) {
            Pair e = q.poll();
            int i = e.first;
            int j = e.second;
            grid[i][j] = color;
            //find neighbours
            if (i - 1 >= 0 && grid[i - 1][j] == oldColor && !vis[i - 1][j]) {
                q.add(new Pair(i - 1, j));
            }
            if (i + 1 < n && grid[i + 1][j] == oldColor && !vis[i + 1][j]) {
                q.add(new Pair(i + 1, j));
            }
            for (int k = j - 1; k <= j + 1; k++) {
                if (k >= 0 && k < n && grid[i][k] == oldColor && !vis[i][k]) {
                    q.add(new Pair(i, k));
                }
            }

        }
    }

    private static void dfs(Pair node, boolean[][] vis, int[][] grid) {
        int n = grid.length;

        int i = node.first;
        int j = node.second;
        vis[node.first][node.second] = true;
        grid[node.first][node.second] = 2;//new color
        int oldColor = 1;
        //find neighbours
        if (i - 1 >= 0 && grid[i - 1][j] == oldColor && !vis[i - 1][j]) {
            vis[i - 1][j] = true;
            dfs(new Pair(i - 1, j), vis, grid);
        }
        if (i + 1 < n && grid[i + 1][j] == oldColor && !vis[i + 1][j]) {
            vis[i + 1][j] = true;
            dfs(new Pair(i + 1, j), vis, grid);
        }
        for (int k = j - 1; k <= j + 1; k++) {
            if (k >= 0 && k < n && grid[i][k] == oldColor && !vis[i][k]) {
                vis[i][k] = true;
                dfs(new Pair(i, k), vis, grid);
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
