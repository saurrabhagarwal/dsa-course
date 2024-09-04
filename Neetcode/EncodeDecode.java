package dsa.NEETCODE;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        List<String> list = List.of("we","say",":","yes","!@#$%^&*()");
        System.out.println(encode(list));
        System.out.println(decode(encode(list)));
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s.length()).append('/').append(s);
        return sb.toString();
    }

    public static List<String> decode(String s) {
        List res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return res;
    }
}
