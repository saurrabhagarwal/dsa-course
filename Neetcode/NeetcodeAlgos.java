package dsa.NEETCODE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NeetcodeAlgos {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }
    }

    public static void main(String[] args) {
        //insertion sort
        int[] arr = new int[]{4, 3, 2, 7, 5, 1};

        insertSort(arr);
        arr = new int[]{4, 3, 2, 7, 5, 1};
        //merge sort
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
        arr = new int[]{4, 3, 2, 7, 5, 1};
        //quick sort
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        //binary search
        System.out.println(binarySearch(arr, 7, 0, arr.length - 1));
        System.out.println(binarySearch(arr, 7));

        //bst
        Node tree = createBST();
        bfs(tree);
        System.out.println(tree);
        tree = removeFromBST(tree, 3);
        System.out.println(tree);

        System.out.println(isBST(tree));

        bfs(tree);
    }

    private static void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        int level = 0;
        while (q.size() > 0) {
            System.out.println("level : " + level);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                System.out.println(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            level++;
        }
    }

    private static boolean isBST(Node root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(Node tree, int minValue, int maxValue) {
        if (tree == null)
            return true;
        if (tree.val < minValue || tree.val > maxValue)
            return false;
        boolean left = isValidBST(tree.left, minValue, tree.val);
        boolean right = isValidBST(tree.right, tree.val, maxValue);
        return left && right;
    }

    private static Node removeFromBST(Node root, int target) {
        if (root == null) return null;
        if (target > root.val)
            root.right = removeFromBST(root.right, target);
        else if (target < root.val)
            root.left = removeFromBST(root.left, target);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                int min = findMinValueInBST(root.right);
                root.val = min;
                root.right = removeFromBST(root.right, min);
            }
        }
        return root;
    }

    private static int findMinValueInBST(Node root) {
        Node curr = root;
        while (curr != null & curr.left != null) curr = curr.left;
        return curr.val;
    }

    private static Node createBST() {
        Node root = new Node(5);
        insertInBST(root, 3);
        insertInBST(root, 1);
        insertInBST(root, 7);
        insertInBST(root, 2);
        return root;
    }

    private static Node insertInBST(Node root, int val) {
        if (root == null) return new Node(val);
        if (val > root.val) root.right = insertInBST(root.right, val);
        else if (val < root.val) root.left = insertInBST(root.left, val);
        return root;
    }


    private static int binarySearch(int[] arr, int target, int start, int end) {
        if (start <= end) {
            int m = (start + end) / 2;
            if (arr[m] < target) return binarySearch(arr, target, m + 1, end);
            else if (arr[m] > target) return binarySearch(arr, target, start, m - 1);
            else return m;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int m = (start + end) / 2;
            if (arr[m] < target) start = m + 1;
            else if (arr[m] > target) end = m - 1;
            else return m;
        }
        return -1;
    }

    private static int[] quickSort(int[] arr, int s, int e) {
        if (e - s + 1 <= 1) return arr;
        int pivot = arr[e];
        int left = s;
        //partition
        for (int i = s; i <= e; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, left);
                left++;
            }
        }
        //swap pivot
        swap(arr, left, e);
        quickSort(arr, s, left - 1);
        quickSort(arr, left + 1, e);
        return arr;
    }

    private static void swap(int[] arr, int i, int left) {
        int t = arr[i];
        arr[i] = arr[left];
        arr[left] = t;
    }


    private static int[] mergeSort(int[] arr, int l, int r) {
        if (r - l + 1 <= 1) {
            return arr;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
        return arr;
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            a2[i] = arr[m + i + 1];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                arr[k] = a1[i];
                i++;
            } else {
                arr[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = a1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = a2[j];
            j++;
            k++;
        }

    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
