package dsa.javaCourse;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapLearn {
    public static void main(String[] args) {
        String s ="Hello";
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        for (Character c : s.toCharArray()) {
            //Note that if you replace the (count + 1) with count++, the updated value is never stored in the map.
//            charMap.computeIfPresent(c, ((character, count) -> count + 1));
//            charMap.putIfAbsent(c, 1);
            charMap.merge(c,2, Integer::sum);
        }

        System.out.println(charMap);

    }
}
