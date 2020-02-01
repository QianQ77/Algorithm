package main.java.leetCode;

import java.util.HashMap;
import java.util.Collections;

/**
 * Created by qiuqian on 9/22/18.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null || pattern == "" && str == "") {
            return true;
        }
        if(pattern == null || str == null || pattern == "" || str == "") {
            return false;
        }

        String[] words = str.trim().split(" ");
        if(words.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if(charToWord.containsKey(c)) {
                if(!(charToWord.get(c).equals(words[i]))) {
                    return false;
                }
            } else {
                if(wordToChar.containsKey(words[i])) {
                    return false;
                }
                charToWord.put(c, words[i]);
                wordToChar.put(words[i], c);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        String pattern = "abba";
        String str = "dog cat cat fish";
        System.out.println(test.wordPattern(pattern, str));
    }
}
