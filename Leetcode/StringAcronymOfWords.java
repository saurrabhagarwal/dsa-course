package dsa.Leetcode;

import java.util.List;

public class StringAcronymOfWords {
    //https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/

    public static void main(String[] args) {
        List<String> words = List.of(new String[]{"alice", "bob", "charlie"});
        System.out.println(isAcronym(words, "abc"));
    }

    public static boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length())
            return false;
        for (int i = 0; i < words.size(); i++) {
            if (!(words.get(i).charAt(0) == s.charAt(i)))
                return false;
        }
        return true;
    }
}
