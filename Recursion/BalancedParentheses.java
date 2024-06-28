package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class BalancedParentheses {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        generateBalancedParentheses(3, 3, builder, list);
        System.out.println(list);
    }

    private static void generateBalancedParentheses(int open, int close, StringBuilder builder, List<String> list) {
        if (open == 0 && close == 0) {
            list.add(builder.toString());
            return;
        }
        if (open > 0)
            generateBalancedParentheses(open - 1, close, new StringBuilder(builder).append("("), list);
        if (close > open)
            generateBalancedParentheses(open, close - 1, new StringBuilder(builder).append(")"), list);
    }
}
