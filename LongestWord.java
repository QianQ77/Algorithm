package main.java.leetCode;

import java.util.Arrays;

/**
 * Created by qiuqian on 1/1/19.
 */
public class LongestWord {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";
        Arrays.sort(words);
        String result = "";
        int currLen = 0;
        int maxLen = 0;
        int i = 0;
        while (i < words.length) {
            if (words[i].length() == currLen + 1 && i < words.length - 1 && valid(words[i], words[i + 1])) {
                currLen++;
            } else {
                if (currLen > maxLen) {
                    result = words[i];
                    maxLen = currLen;
                }
                currLen = 0;
            }
            i++;
        }
        return result;
    }

    private boolean valid(String word, String next) {
        return (next.length() == word.length() + 1) && next.indexOf(word) == 0;
    }

    public static void main(String[] args) {
        LongestWord test = new LongestWord();
        String[] words = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        System.out.println(test.longestWord(words));
    }
}
