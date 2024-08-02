package dsa.Graph;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        int n = 5;
        int[][] adj = new int[n + 1][n + 1];
        //1,2 1,3 2,4 3,4 2,5 4,5

        adj[1][2] = 1;
        adj[1][3] = 1;
        adj[2][4] = 1;
        adj[3][4] = 1;
        adj[2][5] = 1;
        adj[4][5] = 1;

        adj[2][1] = 1;
        adj[3][1] = 1;
        adj[4][2] = 1;
        adj[4][3] = 1;
        adj[5][2] = 1;
        adj[5][4] = 1;

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
      //1,2 1,3 2,4 3,4 2,5 4,5
        list.get(1).add(2);
        list.get(1).add(3);
        list.get(2).add(4);
        list.get(3).add(4);
        list.get(2).add(5);
        list.get(4).add(5);

        list.get(2).add(1);
        list.get(3).add(1);
        list.get(4).add(2);
        list.get(4).add(3);
        list.get(5).add(2);
        list.get(5).add(4);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
