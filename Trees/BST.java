package dsa.Trees;

public class BST {
    class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    Node root;

    public int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void display() {
        display(this.root, 0);
    }

    private void display(Node node, int space) {
        if (node == null) return;
        space += 4;
        display(node.right, space + 1);
        System.out.println();
        for (int i = 0; i < space - 4; i++) {
            System.out.print(" ");
        }
        System.out.println(node.value);
        display(node.left, space + 1);
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void display2() {
        display2(this.root, "Root Node: ");
    }

    private void display2(Node node, String s) {
        if (node == null) return;
        System.out.println(s + node.value);
        display2(node.left, "Left child of " + node.value + ": ");
        display2(node.right, "Right child of " + node.value + ": ");
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populateSorted(int[] arr) {
        populateSorted(arr, 0, arr.length);
    }

    private void populateSorted(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        insert(arr[m]);
        populateSorted(arr, 0, m);
        populateSorted(arr, m + 1, r);
    }

    public int getHeight(Node n) {
        if (n == null) {
            return 0;
        }
        int leftH = getHeight(n.left);
        int rightH = getHeight(n.right);

        return Math.max(leftH,rightH)+1;
    }

    public void preOrder(){
        preOrder(root);
    }

    //N->L->R
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }

    //L->N->R
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.print(node.value+" ");
        preOrder(node.right);
    }
}
