package dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFSTest {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        list.get(1).add(6);
        list.get(2).add(1);
        list.get(2).add(3);
        list.get(2).add(4);
        list.get(3).add(2);
        list.get(4).add(2);
        list.get(4).add(5);
        list.get(5).add(4);
        list.get(5).add(8);
        list.get(6).add(1);
        list.get(6).add(7);
        list.get(6).add(9);
        list.get(7).add(6);
        list.get(7).add(8);
        list.get(8).add(7);
        list.get(8).add(5);
        list.get(9).add(6);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> dfs = dfsOfGraph(1, list);
        System.out.println(dfs);
        System.out.println(dfsOfGraph(6, list));
    }

    public static ArrayList<Integer> dfsOfGraph(int start, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[adj.size() + 1];

        //recursion call
        dfs(start, vis, adj, dfs);
        return dfs;
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
