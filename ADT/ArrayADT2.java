package dsa;

import java.util.Arrays;

public class ArrayADT2 {
    public static void main(String[] args) {
        //union,intersection,difference
        System.out.println(Arrays.toString(union(new int[]{2, 5, 6, 1}, new int[]{7, 1, 8, 2})));

        System.out.println(Arrays.toString(union_sorted(new int[]{1, 2, 3, 4}, new int[]{3, 4, 6, 8, 9})));
        System.out.println(Arrays.toString(intersection(new int[]{3, 4, 1, 2}, new int[]{3, 4, 6, 8, 9})));
        System.out.println(Arrays.toString(intersection_sorted(new int[]{1, 2, 3, 4}, new int[]{3, 4, 6, 8, 9})));
        System.out.println(Arrays.toString(difference(new int[]{1, 2, 3, 4}, new int[]{3, 4, 6, 8, 9})));
        System.out.println(Arrays.toString(difference_sorted(new int[]{1, 2, 3, 4, 8, 9, 10, 20}, new int[]{3, 4, 6, 8, 9})));


        System.out.println(checkIfSorted(new int[]{1, 2, 3, 4}));
        System.out.println(checkIfSorted(new int[]{4, 1, 2, 3, 4}));

        System.out.println(Arrays.toString(arrangeNegative(new int[]{-4, 1, -2, 3, 4, -6})));

        System.out.println(Arrays.toString(merge(new int[]{-4, -2, 3, 4, 6}, new int[]{-4, -3, -2, 1, 4, 16})));
    }

    //not sorted - elements from both array but only once
    public static int[] union(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] arr = new int[m + n];
        int k = 0;
        for (int value : arr1) {
            arr[k] = value;
            k++;
        }
        for (int value : arr2) {
            boolean isDuplicate = false;
            for (int j = 0; j < k; j++) {
                if (value == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                arr[k] = value;
                k++;
            }
        }
        return arr;
    }

    // sorted array - elements from both array but only once
    public static int[] union_sorted(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] arr = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j])
                arr[k++] = arr1[i++];
            else if (arr2[j] < arr1[i])
                arr[k++] = arr2[j++];
            else {
                arr[k++] = arr1[i++];
                j++;
            }
        }
        while (i < m) {
            arr[k++] = arr1[i++];
        }
        while (j < n) {
            arr[k++] = arr2[j++];
        }
        return arr;
    }

    //intersection - common elements array
    public static int[] intersection(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] arr = new int[m + n];
        int k = 0;
        for (int value : arr1) {
            for (int i : arr2) {
                if (value == i)
                    arr[k++] = value;
            }
        }
        return arr;
    }

    // sorted array - common elements array
    public static int[] intersection_sorted(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] arr = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i])
                j++;
            else {
                arr[k++] = arr1[i++];
                j++;
            }
        }
        return arr;
    }

    //difference - A's elements that are not in B
    public static int[] difference(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int[] arr = new int[m];
        int k = 0;
        for (int value : arr1) {
            boolean isPresent = false;
            for (int i : arr2) {
                if (value == i) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) arr[k++] = value;
        }
        return arr;
    }

    //difference with sorted arrays - A's elements that are not in B
    public static int[] difference_sorted(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] arr = new int[m];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else if (arr2[j] < arr1[i])
                j++;
            else {
                i++;
                j++;
            }
        }
        while (i < m) {
            arr[k++] = arr1[i++];
        }
        return arr;
    }

    //left shift - move element to left, 0th index element will be lost
    //rotation - move element to left, 0th index element will be moved to last index
    public void leftShift(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = 0;
    }

    public void rotate(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

    public static boolean checkIfSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static int[] arrangeNegative(int[] arr) {
        int i = 0; //track +ve number
        int j = arr.length - 1; //track -ve number
        while (i < j) {
            while (arr[i] < 0) i++; //continue if -ve
            while (arr[j] >= 0) j--; //continue if +ve
            if (i < j)
                swap(i, j, arr);
        }
        return arr;
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //merge two sorted arrays in single sorted array
    public static int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] arr = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                arr[k] = a[i];
                i++;
            } else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            arr[k] = a[i];
            i++;
            k++;
        }
        while (j < n) {
            arr[k] = b[j];
            j++;
            k++;
        }
        return arr;
    }
}
