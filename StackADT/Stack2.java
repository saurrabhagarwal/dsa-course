package dsa;

public class Stack2 {
    Node top;

    public Stack2(int[] arr) {
        top = new Node();
        top.data = arr[0];
        top.next = null;
        for (int i = 1; i < arr.length; i++) {
            Node t = new Node();
            t.data = arr[i];
            t.next = top;
            top = t;
        }
    }

    public static Stack2 push(Stack2 stack, int k) {
        Node t = new Node();
        t.data = k;
        t.next = stack.top;
        stack.top = t;
        return stack;
    }

    public static Stack2 pop(Stack2 stack) {
        System.out.println("pop " + stack.top.data);
        stack.top = stack.top.next;
        return stack;
    }

    public static int peek(Stack2 stack) {
        return stack.top.data;
    }

    public static boolean isEmpty(Stack2 stack) {
        return stack.top == null;
    }

    public static int search(Stack2 stack, int k) {
        Node t = stack.top;
        int pos = 1;
        while (t != null && t.data != k) {
            pos++;
            t = t.next;
        }
        return t != null ? pos : -1;
    }

    @Override
    public String toString() {
        return "top->" + top;
    }


    public static void main(String[] args) {
        Stack2 stack = new Stack2(new int[]{1, 2, 3, 4});
        System.out.println(stack);

        System.out.println(push(stack, 5));
        System.out.println(push(stack, 50));
        System.out.println(pop(stack));
        System.out.println(peek(stack));
        System.out.println(isEmpty(stack));
        System.out.println("position of 5 - "+search(stack,5));
        System.out.println("position of 50 - "+search(stack,50));
        System.out.println("position of 1 - "+search(stack,1));
    }
}
