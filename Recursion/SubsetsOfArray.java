package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfArray {
    public static void main(String[] args) {
        printSubset("abcd");
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        printSubsetsOfList(input);

        //https://www.codeburps.com/dsa/subsets-of-an-array
        printSubsetsOfArray(new int[]{1, 2, 3});
    }

    private static void printSubsetsOfArray(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsOfArray(arr, 0, new ArrayList<>(), res);
        System.out.println(res);
    }

    private static void subsetsOfArray(int[] arr, int index, List<Integer> output, List<List<Integer>> res) {
        if (index == arr.length) {
            System.out.println(output);
            res.add(output);
            return;
        }
        //not take
        subsetsOfArray(arr, index + 1, new ArrayList<>(output), res);
        output.add(arr[index]);
        subsetsOfArray(arr, index + 1, output, res);
    }

    private static void printSubsetsOfList(List<Integer> input) {
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsetsOfList(input, output, res);
        System.out.println(res);
    }

    private static void subsetsOfList(List<Integer> input, List<Integer> output, List<List<Integer>> res) {
        if (input.size() == 0) {
            System.out.println(output);
            res.add(output);
            return;
        }
        subsetsOfList(removeFirst(input), new ArrayList<>(output), res);   //not select
        subsetsOfList(removeFirst(input), addFirst(input, output), res); //select
    }

    private static List<Integer> addFirst(List<Integer> input, List<Integer> output) {
        output.add(input.get(0));
        return output;
    }

    private static ArrayList<Integer> removeFirst(List<Integer> input) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            res.add(input.get(i));
        }
        return res;
    }

    private static void printSubset(String s) {
        ArrayList<String> list = new ArrayList<>();
        print(s, "", list);
        System.out.println(list);
    }

    private static void print(String ip, String op, ArrayList<String> list) {
        if (ip.length() == 0) {
            System.out.println(op);
            list.add(op);
            return;
        }
        //not select - reduce input
        print(ip.substring(1), op, list);
        // select - reduce input,add in output
        print(ip.substring(1), op + ip.charAt(0), list);
    }
}
