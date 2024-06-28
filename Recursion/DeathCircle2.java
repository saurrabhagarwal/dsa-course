package dsa.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeathCircle2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(i);
        }
        System.out.println(solveCircle(list, 5, 0));

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            q.offer(i);
        }
        solveCircle(q, 2);
    }

    private static int solveCircle(ArrayList<Integer> list, int k, int i) {
        if (list.size() == 1) {
            return list.get(0);
        }
        i = (i + k - 1) % list.size();
        list.remove(i);
        return solveCircle(new ArrayList<>(list), k, i);
    }

    private static void solveCircle(Queue<Integer> q, int k) {
        if (q.size() == 1) {
            System.out.println(q.poll());
            return;
        }
        for (int i = 0; i < k-1; i++) {
            q.offer(q.poll());
        }
        q.poll();
        solveCircle(q, k);
    }
}
