package dsa;

import java.util.Arrays;

class ArrayADT3 {
    static class Array {
        private int[] items;
        private int length;
        private int size;

        public Array(int size) {
            this.size = size;
            this.items = new int[size];
            this.length = 0;
        }

        public void display() {
            System.out.println("displaying items of array");
            for (int i = 0; i < length; i++) {
                System.out.println(items[i]);
            }
        }

        public void add(int el) {
            if (length == size) {
                int[] newArray = new int[size * 2];
                for (int i = 0; i < length; i++) {
                    newArray[i] = items[i];
                }
                items = newArray;
                size = size * 2;
            }
            items[length++] = el;
        }

        public void insert(int index, int el) {
            if (index >= 0 && index < length) {
                for (int i = length; i > index; i--) {
                    items[i] = items[i - 1];
                }
                items[index] = el;
                length++;
            }
        }

        public void delete(int index) {
            if (index >= 0 && index < length) {
                for (int i = index; i < length - 1; i++) {
                    items[i] = items[i + 1];
                }
                length--;
            }
        }

        public int binarySearch(int el) {
            int l = 0;
            int h = length - 1;

            while (l <= h) {
                int m = (l + h) / 2;
                if (items[m] == el)
                    return m;
                else if (items[m] < el) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
            return -1;
        }

        public int get(int index) {
            return items[index];
        }

        public void set(int index, int el) {
            items[index] = el;
        }

        public int max() {
            int max = items[0];
            for (int i = 1; i < length; i++) {
                if (items[i] > max)
                    max = items[i];
            }
            return max;
        }

        public int min() {
            int min = items[0];
            for (int i = 1; i < length; i++) {
                if (items[i] < min)
                    min = items[i];
            }
            return min;
        }

        public int sum() {
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += items[i];
            }
            return sum;
        }

        public double avg() {
            double sum = 0;
            for (int i = 0; i < length; i++) {
                sum += items[i];
            }
            return sum / length;
        }

        public void reverse() {
            int i = 0;
            int j = length - 1;
            while (i < j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        public void swap(int i, int j) {
            int temp = items[i];
            items[i] = items[j];
            items[j] = temp;
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

        //insert in sorted array
        //check if array is sorted
        //arrange negative elements on left side

        public void insertInSortedArray(int el) {
            int index = length;
            for (int i = 0; i < index; i++) {
                if (items[i] > el)
                    index = i;
            }
            //shift all elements after index
            for (int i = length; i > index; i--) {
                items[i] = items[i - 1];
            }
            items[index] = el;
            length++;
        }

        public void insertInSortedArray2(int el) {
            int index = length - 1;

            //shift all elements after index
            while (index >= 0 && items[index] > el) {
                items[index + 1] = items[index];
                index--;
            }
            items[index + 1] = el;
            length++;
        }

        public boolean checkIfSorted(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1])
                    return false;
            }
            return true;
        }

        public int[] arrangeNegative(int[] arr) {
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

        public void swap(int i, int j, int[] arr) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //merge two sorted arrays in single sorted array
        public int[] merge(int[] a, int[] b) {
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

    public static void main(String[] args) {
        Array array = new Array(10);
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.display();
        array.insert(3, 70);
        array.display();
        array.delete(2);
        array.display();
        System.out.println("----");
        System.out.println(array.binarySearch(70));
        System.out.println(array.sum());
        System.out.println(array.max());
        System.out.println(array.min());
        System.out.println(array.avg());
        array.display();
        System.out.println("----");
        array.reverse();
        array.display();
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        array.leftShift(arr);
        System.out.println(Arrays.toString(arr));
        array.rotate(arr);
        System.out.println(Arrays.toString(arr));

        Array array2 = new Array(10);
        for (int i = 0; i < 5; i++) {
            array2.add(i);
        }
        array2.insertInSortedArray(2);
        array2.insertInSortedArray2(60);
        array2.insertInSortedArray2(-60);
        array2.display();

        System.out.println(array2.checkIfSorted(new int[]{1, 2, 3, 4}));
        System.out.println(array2.checkIfSorted(new int[]{4, 1, 2, 3, 4}));

        System.out.println(Arrays.toString(array2.arrangeNegative(new int[]{-4, 1, -2, 3, 4, -6})));

        System.out.println(Arrays.toString(array2.merge(new int[]{-4, -2, 3, 4, 6},new int[]{-4, -3, -2, 1, 4, 16})));
    }
}
