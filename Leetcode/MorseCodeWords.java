package dsa.Leetcode;

import java.util.HashSet;

public class MorseCodeWords {
    public static void main(String[] args) {
        //https://leetcode.com/problems/unique-morse-code-words/submissions/1300030056/
        System.out.println(findCount(new String[]{"abc", "abcd"}));


    }

    public static int findCount(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder s = new StringBuilder();
            for (char c : word.toCharArray()) {
                s.append(codes[c - 'a']);
            }
            set.add(s.toString());
        }

        return set.size();
    }
}
