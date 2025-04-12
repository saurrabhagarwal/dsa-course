package dsa.Notes;

import java.util.Arrays;

public class Array {
    static int[] arr = new int[10];

    public static void main(String[] args) {

        insertInSortedArray1(new int[]{0, 2, 4, 5, 7}, 8);
        insertInSortedArray2(new int[]{0, 2, 4, 5, 7}, 8);
        insertInSortedArray2(new int[]{0, 2, 4, 5, 7}, 1);
        insertInSortedArray2(new int[]{0, 2, 4, 5, 7}, 3);
        insertInSortedArray2(new int[]{0, 2, 4, 5, 7}, 5);
        arrangeNegative(new int[]{-1, 2, -4, 5});
        arrangeNegative(new int[]{3, -1, 2, -4, 5});
        arrangeNegative2(new int[]{-1, 2, -4, 5});
        arrangeNegative2(new int[]{3, -1, 2, -4, 5});
        mergeSortedArrays(new int[]{0, 2, 4, 5, 7}, new int[]{1, 10, 12, 14, 15, 17});
        findMissingElementsInSortedArray(new int[]{0, 2, 4, 5, 7});
        findDuplicatesInSortedArray(new int[]{1, 2, 3, 3, 4, 5, 5, 5, 6, 7});
        findCountOfDuplicatesInSortedArray(new int[]{1, 2, 3, 3, 4, 5, 5, 5, 6, 7});
        findCountOfDuplicatesInSortedArray2(new int[]{1, 2, 3, 3, 4, 5, 5, 5, 6, 7});
        findDuplicates(new int[]{7, 1, 2, 3, 3, 4, 5, 5, 5, 6, 7});
        findPairInSortedArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8);
        findMinMax(new int[]{2, 1, 4, 5, 9, 10, 34, 0});
        moveZeroesToEnd(new int[]{0,4,0,5,3,0,7,0,9,1,1});
    }

    //insert at any index - right shift
    static void insertAtIndex(int index, int value) {
        for (int i = arr.length - 1; i > index; i--) {
            //swap
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
    }

    //delete any index - left shift
    static void deleteIndex(int index) {
        for (int i = index; i < arr.length; i++) {
            //swap
            arr[i] = arr[i + 1];
        }
    }

    //max min sum avg

    //reverse array
    static void reverse() {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    //left shift - 0th element lost, last element =0
    static void leftShift() {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    //rotate - 0th element will go to last element
    static void rotate() {
        int last = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = last;
    }

    //insert in sorted array
    static void insertInSortedArray1(int[] arr, int el) {
        int[] arr2 = new int[arr.length + 1];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        int index = arr.length;
        for (int i = 0; i < index; i++) {
            if (arr[i] > el) index = i; //new index
        }
        //right shift
        for (int i = arr.length; i > index; i--) {
            arr2[i] = arr2[i - 1];
        }
        arr2[index] = el;
        System.out.println(Arrays.toString(arr2));
    }

    //insert in sorted array
    static void insertInSortedArray2(int[] arr, int el) {
        int[] arr2 = new int[arr.length + 1];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        int n = arr.length;
        int index = n - 1; // Start from the second last index of arr2;
        while (index >= 0 && arr[index] > el) {
            arr2[index + 1] = arr[index];
            index--;
        }
        arr2[index + 1] = el; // Insert the element at the correct position
        System.out.println(Arrays.toString(arr2));
    }

    static void checkIfSorted(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println("Is sorted: " + isSorted);
    }

    //negative in left and positive in right side
    static void arrangeNegative(int[] arr) {
        int i = 0; //negative
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < 0) {
                swap(arr, i, j);
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //negative in left and positive in right side
    static void arrangeNegative2(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            while (arr[l] < 0) l++;
            while (arr[r] > 0) r--;
            if (l < r) swap(arr, l, r);
        }
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) arr[k++] = arr1[i++];
            else arr[k++] = arr2[j++];

        }
        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
        System.out.println(Arrays.toString(arr));
    }

    //find Missing Elements In Sorted Array
    static void findMissingElementsInSortedArray(int[] arr) {
        System.out.println("findMissingElementsInSortedArray " + Arrays.toString(arr));
        int diff = arr[0]; // Initial difference
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] - i > diff) {
                System.out.println(i + diff);
                diff++;
            }
        }
    }

    //find duplicates in sorted array
    static void findDuplicatesInSortedArray(int[] arr) {
        System.out.println("findDuplicatesInSortedArray " + Arrays.toString(arr));
        int lastDup = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && lastDup != arr[i]) {
                System.out.println(arr[i]);
                lastDup = arr[i];
            }
        }
    }

    //find count of duplicates in sorted array
    static void findCountOfDuplicatesInSortedArray(int[] arr) {
        System.out.println("findCountOfDuplicatesInSortedArray " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                int j = i + 1;
                while (arr[i] == arr[j]) j++;
                System.out.println(arr[i] + " => " + (j - i) + " times dups");
                i = j;
            }
        }
    }

    //find count of duplicates in sorted array
    static void findCountOfDuplicatesInSortedArray2(int[] arr) {
        System.out.println("findCountOfDuplicatesInSortedArray " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                int count = 1;
                while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    i++;
                    count++;
                }
                System.out.println(arr[i] + " => " + (count) + " times dups");
            }
        }
    }

    //find duplicates in unsorted array
    static void findDuplicates(int[] arr) {
        System.out.println("findDuplicates " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 1;
            if (arr[i] != -1) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        arr[j] = -1;
                    }
                }
            }
            if (count > 1)
                System.out.println(arr[i] + " is appearing " + count + " times");
        }
    }

    public static void findPairInUnSortedArray(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.println("pair " + arr[i] + " " + arr[j]);
                }
            }
        }
        System.out.println();
    }

    public static void findPairInSortedArray(int[] arr, int k) {
        System.out.println("findPairInSortedArray for " + k + " in " + Arrays.toString(arr));
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] == k) {
                System.out.println("pair " + arr[l] + " + " + arr[r]);
                l++;
                r--;
            } else if (arr[l] + arr[r] < k) {
                l++;
            } else r--;
        }
    }

    public static void findMinMax(int[] arr) {
        System.out.println("findMinMax " + Arrays.toString(arr));
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println("min " + min);
        System.out.println("max " + max);
    }

    static void moveZeroesToEnd(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            while (arr[l] > 0)
                l++;
            while (arr[r] == 0)
                r--;
            if (l < r)
                swap(arr, l, r);
        }
        System.out.println(Arrays.toString(arr));
    }
}
