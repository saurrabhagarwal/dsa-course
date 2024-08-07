package dsa.Graph;

import java.util.ArrayList;

public class CycleInDGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        list.get(2).add(3);
        list.get(3).add(4);
        list.get(3).add(7);
        list.get(4).add(5);
        list.get(5).add(6);
        list.get(7).add(5);
        list.get(8).add(2);
        list.get(8).add(9);
        list.get(9).add(10);
        list.get(10).add(8);
        System.out.println(isCycle(list));
    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> list) {
        boolean vis[] = new boolean[list.size()];
        boolean pathVis[] = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (!vis[i]) {
                if (dfsCheck(i, vis, pathVis, list))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfsCheck(int node, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> list) {
        vis[node] = true;
        pathVis[node] = true;
        for (int e : list.get(node)) {
            if (!vis[e]) {
                if (dfsCheck(e, vis, pathVis, list))
                    return true;
            } else if (pathVis[e]) {
                System.out.println("cycle at " + e);
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}
