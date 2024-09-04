package dsa.NEETCODE;

import java.util.Arrays;

public class Revision {
    public static void main(String[] args) {
        //insert at any index
        int[] arr = {4,3,7,2,5,0};
        insertAtIndex(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertAtIndex(int[] arr, int k) {
        for (int i = arr.length-1; i >k ; i--) {
            arr[i] = arr[i-1];
        }
        arr[k]=10;
    }
}
