package dsa;

import java.util.Arrays;

public class Stack1 {
    int[] arr;
    int size;
    int top = -1;

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                ", top=" + top +
                '}';
    }

    public void printStack() {
        System.out.print("size - " + size + " Elements - ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public Stack1(int size) {
        this.arr = new int[size];
        this.size = size;
    }

    public Stack1(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.top = size - 1;
    }

    public void push(int val) {
        if (top + 1 == size) {
            System.out.println("stack is full");
            return;
        }
        top++;
        arr[top] = val;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("stack is empty");
            return -1;
        }
        int val = arr[top];
        top--;
        return val;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("stack is empty");
            return -1;
        }
        return arr[top];
    }

    public static int search(Stack1 stack, int k) {
        int[] arr = stack.arr;
        int t = stack.top;
        int pos = 1;
        while (t >= 0 && arr[t] != k) {
            pos++;
            t--;
        }

        return (t!=-1 ) ? pos : -1;
    }

    public static void main(String[] args) {
        Stack1 stack = new Stack1(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.printStack();
        stack.push(50);
        stack.push(60);
        stack.printStack();
        Stack1 stack2 = new Stack1(new int[]{1, 2, 3, 4, 5});
        stack2.printStack();
        System.out.println("pop - " + stack2.pop());
        stack2.printStack();
        System.out.println("pop - " + stack2.pop());
        stack2.printStack();
        System.out.println("peek - " + stack2.peek());

        System.out.println("position of 3 - " + search(stack2, 3));
        System.out.println("position of 1 - " + search(stack2, 1));
        System.out.println("position of 5 - " + search(stack2, 5));
    }
}
