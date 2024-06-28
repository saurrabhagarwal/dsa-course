package dsa;

import java.util.Arrays;

public class SwapSort {
    public static void main(String[] args) {
        //find duplicate & missing number from 1 to N array
        int[] arr = {3,3,2};
        swapSort(arr);
    }

    private static void swapSort(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            if (arr[i] != i + 1 && arr[arr[i] - 1] != arr[i]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                System.out.println("duplicate " + arr[j]);
                System.out.println("missing " + (j + 1));
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        System.out.println("swap");
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
