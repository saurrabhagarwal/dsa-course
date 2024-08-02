package dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static dsa.Graph.DFSTest.dfsOfGraph;

public class numberOfProvinces {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        list.get(1).add(3);
        list.get(2).add(1);
        list.get(3).add(1);
        list.get(4).add(5);
        list.get(5).add(4);
        boolean[] vis = new boolean[6 + 1];
        ArrayList<Integer> dfs = new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, vis, list, dfs);
                vis[i] = true;
            }
        }
        System.out.println("number of provinces " + count);
        System.out.println(dfs);


        boolean[] visBFS = new boolean[6 + 1];
        ArrayList<Integer> bfs = new ArrayList<>();
        int countBFS = 0;
        for (int i = 1; i <= 6; i++) {
            if (!visBFS[i]) {
                countBFS++;
                bfs(i, visBFS, list, bfs);
                visBFS[i] = true;
            }
        }
        System.out.println("number of provinces " + countBFS);
        System.out.println(bfs);
    }

    private static void bfs(int start, boolean[] vis, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> bfs) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start]=true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);
            for (int e : list.get(node)) {
                if (!vis[e]) {
                    q.add(e);
                    vis[e] = true;
                }
            }
        }

    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        vis[node] = true;
        dfs.add(node);
        for (int a : adj.get(node)) {
            if (!vis[a]) {
                vis[a] = true;
                dfs(a, vis, adj, dfs);
            }
        }
    }
}
