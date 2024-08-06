package dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInBFS {
    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            list.add(new ArrayList<>());
        }
        //{{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
        list.get(0).add(1);
        list.get(1).add(0);
        list.get(1).add(2);
        list.get(1).add(4);
        list.get(2).add(1);
        list.get(2).add(3);
        list.get(3).add(2);
        list.get(3).add(4);
        list.get(4).add(1);
        list.get(4).add(3);

        System.out.println(list);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, -1));
        boolean[] vis = new boolean[5];
        vis[0] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            // go to all the adjacent nodes
            for (int e : list.get(p.first)) {
                if (!vis[e]) {
                    q.add(new Pair(e, p.first));
                    vis[e] = true;
                }
                // if adjacent node is visited and is not its own parent node
                else if (vis[e] && e != p.second) {
                    System.out.println("Cycle Detected for "+e);
                    return;
                }
            }
        }
    }
}
