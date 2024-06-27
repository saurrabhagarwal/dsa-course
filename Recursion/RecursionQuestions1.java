package dsa.recursion;

import java.util.*;

public class RecursionQuestions1 {
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        printOneToN(10);
        printNtoOne(10);
        System.out.println(fact(5));
        //sum of first n natural  numbers using recursion
        System.out.println(sumOfN(10));
        ////power using recursion
        System.out.println(power(2, 5));
        System.out.println(power2(2, 5));
        System.out.println(fib(10));
        System.out.println(fib2(10));
        TOH(5, 1, 2, 3);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(2);
        System.out.println(sort(list));
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(2);
        System.out.println(sortStack(stack));

        System.out.println(deleteMid(stack));
        System.out.println(reverseStack(stack));
        System.out.println(kthGrammar(2, 1));
    }

    private static int kthGrammar(int n, int k) {
        if (n == 1 && k == 1)
            return 0;
        int mid = (int) Math.pow(2, n - 1) / 2;
        if (k <= mid)
            return kthGrammar(n - 1, k);
        else
            return 1 - kthGrammar(n - 1, k - mid);
    }

    private static Stack<Integer> reverseStack(Stack<Integer> stack) {
        if (stack.size() == 1)
            return stack;
        int temp = stack.pop();
        reverseStack(stack);
        insertAtEndOfStack(stack, temp);
        return stack;
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

    private static Stack<Integer> deleteMid(Stack<Integer> stack) {
        if (stack.size() == 0)
            return stack;
        int k = (stack.size() / 2) + 1;
        deleteK(stack, k);
        return stack;
    }

    private static void deleteK(Stack<Integer> stack, int k) {
        if (k == 1) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteK(stack, k - 1);
        stack.push(temp);
    }

    private static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (stack.size() == 1)
            return stack;
        int temp = stack.pop();
        stack = sortStack(stack);
        insertINStack(stack, temp);
        return stack;
    }

    private static Stack<Integer> insertINStack(Stack<Integer> stack, int temp) {
        if (stack.size() == 0 || stack.peek() <= temp) {
            stack.push(temp);
            return stack;
        }
        int val = stack.pop();
        insertINStack(stack, temp);
        stack.push(val);
        return stack;
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> list) {
        System.out.println("sort called");
        if (list.size() == 1)
            return list;
        int temp = list.remove(list.size() - 1);
        list = sort(list);
        return insert(list, temp);
    }

    private static ArrayList<Integer> insert(ArrayList<Integer> list, int temp) {
        System.out.println("insert called");
        if (list.size() == 0 || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return list;
        }
        int val = list.remove(list.size() - 1);
        insert(list, temp);
        list.add(val);
        return list;
    }

    private static void TOH(int disk, int A, int B, int C) {
        if (disk > 0) {
            TOH(disk - 1, A, C, B);
            System.out.println("Moving Disk " + disk + " from " + A + " to " + C);
            TOH(disk - 1, B, A, C);
        }
    }

    private static int fib(int n) {
        System.out.println("fib called for " + n);
        if (n == 1 || n == 0)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    private static int fib2(int n) {
        System.out.println("fib2 called for " + n);
        if (map.get(n) != null) {
            System.out.println("fib2 returned for " + n);
            return map.get(n);
        }
        if (n == 1 || n == 0) {
            map.put(n, n);
            return n;
        }
        int v1 = fib2(n - 1);
        int v2 = fib2(n - 2);
        map.put(n - 1, v1);
        map.put(n - 2, v2);
        return v1 + v2;
    }

    private static int power2(int n, int p) {
        System.out.println("---");
        if (p == 1)
            return n;
        if (p % 2 == 0)
            return power2(n * n, p / 2);
        else return n * power2(n * n, (p - 1) / 2);
    }

    private static int power(int n, int p) {
        System.out.println("-");
        if (p == 1)
            return n;
        return n * power(n, p - 1);
    }

    private static int sumOfN(int n) {
        if (n == 1)
            return 1;
        return n + sumOfN(n - 1);
    }

    private static int fact(int n) {
        if (n == 1)
            return 1;
        return n * fact(n - 1);

    }

    private static void printNtoOne(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNtoOne(n - 1);

    }

    private static void printOneToN(int n) {
        if (n == 0) {
            return;
        }
        printOneToN(n - 1);
        System.out.println(n);
    }
}
