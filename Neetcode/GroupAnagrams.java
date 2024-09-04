package dsa.NEETCODE;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //char[] c = s.toCharArray();
            //Arrays.sort(c);
            //String k = String.valueOf(c);
            //map.computeIfAbsent(k,key->new ArrayList<>()).add(s);
            int[] c = new int[26];
            for (char ch : s.toCharArray()) {
                c[ch - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < c.length; i++) {
                if (c[i] > 0)
                    stringBuilder.append((char)i + 'a').append(c[i]);
            }
            String k = stringBuilder.toString();
            List<String> l = map.getOrDefault(k, new ArrayList<>());
            l.add(s);
            map.put(k, l);
        }
        System.out.println(map.values());
    }
}
