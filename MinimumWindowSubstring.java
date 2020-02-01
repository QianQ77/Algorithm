package main.java.leetCode;

import java.util.HashMap;

/**
 * Created by qiuqian on 10/18/18.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> tChars = new HashMap<>();
        for(char c : t.toCharArray()) {
            Integer count = tChars.get(c);
            if(count == null) {
                count = 0;
            }
            tChars.put(c, count + 1);
        }
        int matchCount = 0;

        int length = Integer.MAX_VALUE;
        String result = "";
        int i = 0;
        while(i < s.length() && !tChars.containsKey(s.charAt(i))) {
            i++;
        }
        int end = i;
        char c;
        while(i < s.length()) {
            while(i < s.length() && !tChars.containsKey(s.charAt(i))) {
                i++;
            }
            while(matchCount < t.length() && end < s.length()) {
                c = s.charAt(end);
                if(tChars.containsKey(c)) {
                    tChars.put(c, tChars.get(c) - 1);
                    if(tChars.get(c) >= 0) {
                        matchCount += 1;
                    }
                }
                end++;
            }
            if(matchCount == t.length() && end - i < length) {
                length = end - i;
                result = s.substring(i, end);
            }
            if(end == s.length()) {
                return result;
            }
            c= s.charAt(i);
            tChars.put(c, tChars.get(c) + 1);
            if(tChars.get(c) > 0) {
                matchCount -= 1;
            }
            i++;
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
