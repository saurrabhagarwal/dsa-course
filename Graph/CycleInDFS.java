package dsa.Graph;

import java.util.ArrayList;

public class CycleInDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        for (int i = 0; i <= 4; i++) {
//            list.add(new ArrayList<>());
//        }
//        //{{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
//        list.get(0).add(1);
//        list.get(1).add(0);
//        list.get(1).add(2);
//        list.get(1).add(4);
//        list.get(2).add(1);
//        list.get(2).add(3);
//        list.get(3).add(2);
//        list.get(3).add(4);
//        list.get(4).add(1);
//        list.get(4).add(3);
//
//        System.out.println(list);
        for (int i = 0; i <= 7; i++) {
            list.add(new ArrayList<>());
        }
        //{{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
        list.get(1).add(3);
        list.get(1).add(2);
        list.get(2).add(1);
        list.get(2).add(5);
        list.get(3).add(1);
        list.get(3).add(4);
        list.get(3).add(6);
        list.get(4).add(3);
        list.get(5).add(2);
        list.get(5).add(7);
        list.get(6).add(3);
        list.get(6).add(7);
        list.get(7).add(5);
        list.get(7).add(6);
        System.out.println(list);

        boolean[] vis = new boolean[list.size()];
//        boolean isCycleFound = dfs(1, -1, vis, list);
//        System.out.println(isCycleFound);
        //for multiple components
        for (int i = 0; i < list.size(); i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, list)) {
                    System.out.println("True");
                    return;
                }
            }
        }
    }

    private static boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> list) {
        vis[node] = true;
        for (int e : list.get(node)) {
            if (!vis[e]) {
                if (dfs(e, node, vis, list))
                    return true;
            } else if (vis[e] && e != parent) {
                return true;
            }
        }
        return false;
    }
}
