package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack3<E> {
    List<E> arr;
    int size;
    int top = -1;

    public void printStack() {
        System.out.print("size - " + size + " Elements - ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public Stack3(int size) {
        this.arr = new ArrayList<E>(size);
        this.size = size;
    }

    public Stack3(List<E> arr) {
        this.arr = new ArrayList<>(arr);
        this.size = arr.size();
        this.top = size - 1;
    }

    public void push(E val) {
        if (top + 1 == size) {
            System.out.println("stack is full");
            return;
        }
        top++;
        this.arr.add(val);
    }

    public E pop() {
        if (top == -1) {
            System.out.println("stack is empty");
            return null;
        }
        E val = arr.get(top);
        top--;
        return val;
    }

    public E peek() {
        if (top == -1) {
            System.out.println("stack is empty");
            return null;
        }
        return arr.get(top);
    }

    public int search(Stack3<E> stack, E k) {
        List<E> arr = stack.arr;
        int t = stack.top;
        int pos = 1;
        while (t >= 0 && arr.get(t) != k) {
            pos++;
            t--;
        }

        return (t != -1) ? pos : -1;
    }

    static boolean areBracketsBalanced(Stack3<Character> stack, String expr) {
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                //empty stack
                if (stack.pop() == null)
                    return false;
            }
        }
        return stack.top == -1;
    }

    static boolean areAllBracketsBalanced(Stack3<Character> stack, String expr) {
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            Character check;
            switch (c) {
                case ')':
                    check = stack.pop();
                    if (check == null || check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == null || check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == null || check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return stack.top == -1;
    }

    public static void main(String[] args) {
        Stack3 stack = new Stack3(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.printStack();
        stack.push(50);
        stack.push(60);
        stack.printStack();
        Stack3 stack2 = new Stack3(Arrays.asList(1, 2, 3, 4, 5));
        stack2.printStack();
        System.out.println("pop - " + stack2.pop());
        stack2.printStack();
        System.out.println("pop - " + stack2.pop());
        stack2.printStack();
        System.out.println("peek - " + stack2.peek());

        System.out.println("position of 3 - " + stack2.search(stack2, 3));
        System.out.println("position of 1 - " + stack2.search(stack2, 1));
        System.out.println("position of 5 - " + stack2.search(stack2, 5));

        Stack3<Character> characterStack = new Stack3<>(10);
        System.out.println(areBracketsBalanced(characterStack, "((8+1)*(8-1)))"));
        System.out.println(areAllBracketsBalanced(characterStack, "((8+1)*(8-1)))"));
    }
}
