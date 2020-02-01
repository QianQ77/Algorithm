package main.java.leetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by qiuqian on 8/23/18.
 */
public class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[256];
        //error point: should initialize the charIndex to be all -1;
        //error point: these code cannot initialize charIndex to be all -1;
        /*
        for(int index : charIndex) {
            index = -1;
        }
        */
        for(int i = 0; i < charIndex.length; i++) {
            charIndex[i] = -1;
        }
        int start = 0;
        int result = 0;
        int end = 0;
        while(end < s.length()) {
            //error point: should not be if(charIndex[s.charAt(end)] != 0) because 0 can be real index;
            //error point: should check if this index >= start; e.g. abab when start = 1, end = 2, this a should not be considered as repeating character
            if(charIndex[s.charAt(end)] >= start) {
                result = Math.max(result, end - start);
                start = charIndex[s.charAt(end)] + 1;
            }
            charIndex[s.charAt(end)] = end;
            end++;
        }
        result = Math.max(result, end - start);
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        //error point: shoule initialize result to be 1 instead of 0
        int result = 1;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int end = start;
        char[] chars = s.toCharArray();
        while(end < s.length() && start <= end) {

            if(map.containsKey(chars[end])) {
                result = Math.max(result, end - start);
                start = Math.max(map.get(chars[end]) + 1, start);
            }
            map.put(chars[end], end);
            end++;
        }
        //error point: should also set result after the loop
        result = Math.max(result, end - start);
        return result;
    }

    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        if(s == null || s.length() == 0) {
            return result;
        }
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int currLen = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(index[c] == -1) {
                currLen++;
                index[c] = i;
            } else {
                result = Math.max(result, currLen);
                // error point: should not clear index[c]
                // error point: clear(index, s, i - currLen, index[c]);
                clear(index, s, i - currLen, index[c] - 1);
                currLen = i - index[c];
                index[c] = i;
            }
        }
        return result;
    }

    private void clear(int[] index, String s, int start, int end) {
        while(start <= end) {
            index[s.charAt(start)] = -1;
            start++;
        }
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar test = new LongestSubstringWithoutRepeatingChar();
        String s = "abcabcbb";
        System.out.println(test.lengthOfLongestSubstring3(s));
    }
}
