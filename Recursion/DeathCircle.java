package dsa.recursion;

import java.util.Stack;

public class DeathCircle {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.add(4);
        stack.add(3);
        stack.add(2);
        stack.add(1);
        System.out.println(stack);
        solveCircle(stack, 2);
    }

    private static void solveCircle(Stack<Integer> stack, int k) {
        if (stack.size() == 1) {
            System.out.println(stack.peek());
            return;
        }
        for (int i = 1; i < k; i++) {
            int temp = stack.pop();
            insertAtEndOfStack(stack, temp);
        }
        stack.pop();
        solveCircle(stack, k);
    }

    private static void insertAtEndOfStack(Stack<Integer> stack, int temp) {
        if (stack.size() == 0) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insertAtEndOfStack(stack, temp);
        stack.push(val);
    }
}
