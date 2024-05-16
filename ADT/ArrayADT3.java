package dsa;

public class ArrayADT3 {
    public static void main(String[] args) {
        System.out.println(findMissingElement(new int[]{1, 2, 3, 5}));

        findMissingElementsInSortedArray(new int[]{1, 2, 3, 5, 6, 9});
        findMissingElementsInSortedArray2(new int[]{1, 2, 3, 5, 6, 9});
        findMissingElementsInSortedArray3(new int[]{1, 2, 3, 5, 6, 9});

        findDuplicatesInSortedArray(new int[]{3, 6, 8, 8, 10, 12, 15, 15, 15, 20});
        findCountOfDuplicatesInSortedArray(new int[]{3, 6, 8, 8, 10, 12, 15, 15, 15, 20});
        findCountOfDuplicatesInSortedArray2(new int[]{3, 6, 8, 8, 10, 12, 15, 15, 15, 20});

        findDuplicatesInUnSortedArray(new int[]{3, 6, 8, 8, 10, 12, 15, 15, 15, 20});
        findDuplicatesInUnSortedArray(new int[]{20, 15, 3, 6, 8, 8, 10, 12, 15, 15});

        findPairInUnSortedArray(new int[]{6, 3, 8, 10, 16, 7, 5, 2, 4}, 10);
        findPairInUnSortedArray2(new int[]{6, 3, 8, 10, 16, 7, 5, 2, 4}, 10);

        findPairInSortedArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);

        findMinMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 90, -10});
    }

    public static int findMissingElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1)
                return i + 1;
        }
        return -1;
    }

    public static void findMissingElementsInSortedArray(int[] arr) {
        int count = 0;
        for (int i = arr[0]; i <= arr[arr.length - 1]; i++) {
            if (arr[count] == i)
                count++;
            else
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void findMissingElementsInSortedArray2(int[] arr) {
        int diff = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - i != diff) {
                while (diff < arr[i] - i) {
                    System.out.print(i + diff + " ");
                    diff++; //new diff
                }
            }
        }
        System.out.println();
    }

    public static void findMissingElementsInSortedArray3(int[] arr) {
        int[] h = new int[arr[arr.length - 1] + 1];
        for (int j : arr) {
            h[j]++;
        }
        for (int i = 1; i < h.length; i++) {
            if (h[i] == 0)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void findDuplicatesInSortedArray(int[] arr) {
        int lastDup = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && lastDup != arr[i]) {
                System.out.print(arr[i] + " ");
                lastDup = arr[i];
            }
        }
        System.out.println();
    }

    public static void findCountOfDuplicatesInSortedArray(int[] arr) {
        //3, 6, 8, 8, 10, 12, 15, 15, 15, 20
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                int j = i + 1;
                while (arr[j] == arr[i])
                    j++;
                System.out.println(arr[i] + " is appearing " + (j - i) + " times");
                i = j - 1;
            }
        }
        System.out.println();
    }

    public static void findCountOfDuplicatesInSortedArray2(int[] arr) {
        //3, 6, 8, 8, 10, 12, 15, 15, 15, 20
        int[] h = new int[arr[arr.length - 1] + 1];
        for (int j : arr) {
            h[j]++;
        }
        for (int i = 0; i < h.length; i++) {
            if (h[i] > 1)
                System.out.println(i + " is appearing " + h[i] + " times");
        }
        System.out.println();
    }

    public static void findDuplicatesInUnSortedArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 1;
            if (arr[i] != -1) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        arr[j] = -1;
                    }
                }
                if (count > 1)
                    System.out.println(arr[i] + " is appearing " + count + " times");
            }
        }
        System.out.println();
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

    public static void findPairInUnSortedArray2(int[] arr, int k) {
        int[] h = new int[16 + 1];

        for (int i = 0; i < arr.length; i++) {
            if (k - arr[i] >= 0 && h[k - arr[i]] != 0) {
                System.out.println("pair " + arr[i] + " " + (k - arr[i]));
            }
            h[arr[i]]++;
        }
        System.out.println();
    }

    public static void findPairInSortedArray(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == k) {
                System.out.println("pair " + arr[i] + " " + arr[j]);
                i++;
                j++;
            } else if (arr[i] + arr[j] > k)
                j--;
            else i++;
        }
        System.out.println();
    }

    public static void findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            else if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("min " + min + " max " + max);
    }
}
