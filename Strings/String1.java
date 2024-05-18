package dsa.Strings;

public class String1 {
    public static void main(String[] args) {
        char c = 'A';
        int n = 65;
        System.out.println(String.format("%d", (int) c));
        System.out.println(String.format("%c", c));
        System.out.println(String.format("%s", c));
        System.out.println(String.format("%d", n));
        System.out.println(String.format("%c", n));
        System.out.println(String.format("%s", (char) n));

        System.out.println(toggleCase("WeLcOmE"));
        System.out.println(countOfWords("  Who are   you  "));
        System.out.println(countOfWord2("   Who are   you "));

        reverseString("Geeks for Geeks");
        reverseString2("Geeks for Geeks");

        System.out.println(checkPalindrome("asnsa"));
        System.out.println(checkPalindrome("asnsas"));
        System.out.println(checkPalindrome2("asnsa"));
        System.out.println(checkPalindrome2("asnsas"));

        System.out.println(compareStrings("asnaa", "asnaa"));
        System.out.println(compareStrings("asnaa", "asnaa2"));
        compareStrings2("Painter", "Painter");
        compareStrings2("Paintex", "Painter");
        compareStrings2("Painter", "Painting");
        compareStrings2("Painter", "Painter");
        compareStrings2("Painter", "Paint");
        compareStrings2("Paint", "Painter");

        System.out.println(compareStrings3("Painter", "Painter"));
        System.out.println(compareStrings3("Paintex", "Painter"));
        System.out.println(compareStrings3("Painter", "Painting"));
        System.out.println(compareStrings3("Painter", "Paint"));
        System.out.println(compareStrings3("Paint", "Painter"));

        findDuplicates("finding");
        findDuplicates2("finding");
        findDuplicates3("finding");

        System.out.println(checkAnagram("medical","decimal"));
        System.out.println(checkAnagram("medical","decimac"));
    }

    //toggleCase - A to a and a to A
    public static String toggleCase(String s) {
        String newS = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                //newS += (char)(c - 32);
                newS += (char) (c + 'A' - 'a');
            } else if (c >= 'A' && c <= 'Z')
                newS += (char) (c + 'a' - 'A');
        }
        return newS;
    }

    //spaces+1 
    public static int countOfWords(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ')
                count++;
        }
        return count;
    }

    //spaces //"  Who are   you  "
    public static int countOfWord2(String s) {
        //"  Who are   you  "
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) != ' ' && i == 0) || (s.charAt(i) != ' ' && s.charAt(i - 1) == ' '))
                count++;
        }
        return count;
    }

    public static void reverseString(String s) {
        char[] temp = s.toCharArray();
        int i = 0;
        int j = temp.length - 1;
        while (i < j) {
            //swap
            char t = temp[i];
            temp[i] = temp[j];
            temp[j] = t;
            i++;
            j--;
        }
        System.out.println(new String(temp));
    }

    public static void reverseString2(String s) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            newString = s.charAt(i) + newString;
        }
        System.out.println(newString);
    }

    public static boolean checkPalindrome(String s) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            newString = s.charAt(i) + newString;
        }
        return newString.equals(s);
    }

    public static boolean checkPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if ((s.charAt(i) != s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    //Alphabetical Order
    public static void compareStrings2(String s1, String s2) {
        System.out.println("comparing " + s1 + " " + s2);
        int m = s1.length();
        int n = s2.length();
        int i;
        for (i = 0; i < m && i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
        }

        if (i >= m || i >= n) {
            if (m == n)
                System.out.println("Equals");
            else if (m > n)
                System.out.println("Larger");
            else
                System.out.println("Smaller");
        } else if (s1.charAt(i) < s2.charAt(i)) {
            System.out.println("Smaller");
        } else if (s1.charAt(i) > s2.charAt(i)) {
            System.out.println("Larger");
        }
    }

    public static int compareStrings3(String s1, String s2) {
        System.out.println("comparing " + s1 + " " + s2);
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return s1.charAt(i) - s2.charAt(i);
        }
        if (s1.length() == s2.length())
            return 0;
        else return s1.length() - s2.length();
    }

    //like array - unsorted
    public static void findDuplicates(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int count = 1;
            if (chars[i] != 0) { //if already not checked
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        count++;
                        chars[j] = 0;//to mark already checked
                    }
                }
            }
            if (count > 1)
                System.out.println(chars[i] + " - " + count + " times");
        }
    }

    //hashtable
    public static void findDuplicates2(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 1)
                System.out.println((char) (i + 'a') + " - " + chars[i] + " times");
        }
    }

    //bit manipulation
    public static void findDuplicates3(String s) {
        int h = 0; // int- 4 bytes = 32 bits (we need to store 26 bits)
        int x; // temp for masking & merging

        for (int i = 0; i < s.length(); i++) {
            x = 1; //assign first with 1
            x = x << (s.charAt(i) - 'a'); //left shift by ith bits
            //masking to check if bit is ON/OFF
            if ((h & x) > 0)
                System.out.println(s.charAt(i) + " is duplicate");
            else
                h = h | x; //merging
        }
    }

    //same characters in both strings
    public static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] frequencies = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            frequencies[s1.charAt(i) - 'a']++;
            frequencies[s2.charAt(i) - 'a']--;
        }
        for (int frequency : frequencies) {
            if (frequency != 0)
                return false;
        }

        return true;
    }
}
