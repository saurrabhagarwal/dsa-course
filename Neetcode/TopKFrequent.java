package dsa.NEETCODE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 7, 7, 7, 3};
        int target = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        System.out.println(pq);

        int[] output = new int[target];
        for (int i = 0; i < target; i++) {
            output[i]= pq.poll().getKey();
        }
        System.out.println(pq);
        System.out.println(Arrays.toString(output));
    }
}
