package dsa.NEETCODE;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {4,5,6};
        int target =10;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                System.out.println(Arrays.toString(new int[]{map.get(nums[i]), i}));
            } else{
                map.put(target-nums[i],i);
            }
        }
        System.out.println(Arrays.toString(new int[]{-1, -1}));
    }
}
