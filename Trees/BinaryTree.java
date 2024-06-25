package dsa.Trees;

import java.util.Scanner;

public class BinaryTree {
    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    //insert Elements
    public void populate(Scanner scanner) {
        System.out.println("Enter root node value");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    //helper to fill tree
    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to add left of " + node.value);
        int left = scanner.nextInt();

        if (left > 0) {
            //System.out.println("enter left value of " + node.value);
            //int value = scanner.nextInt();
            node.left = new Node(left);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to add right of " + node.value);
        int right = scanner.nextInt();
        if (right > 0) {
            //System.out.println("enter right value of " + node.value);
            //int value = scanner.nextInt();
            node.right = new Node(right);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String s) {
        if (node == null) return;
        System.out.println(s + node.value);
        display(node.left, s + "\t");
        display(node.right, s + "\t");
    }

    public void display2() {
        display2(this.root, 0);
    }

    private void display2(Node node, int space) {
        if (node == null)
            return;
        space +=4;
        display2(node.right, space + 1);
        System.out.println();
        for (int i = 0; i < space-4; i++) {
            System.out.print(" ");
        }
        System.out.println(node.value);
        display2(node.left, space + 1);
    }
}
