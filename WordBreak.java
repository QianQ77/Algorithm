package main.java.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qiuqian on 7/26/17.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[][] isWord = new boolean[length][length];
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(wordDict.indexOf(s.substring(i, j + 1)) != -1){
                    isWord[i][j] = true;
                }else{
                    isWord[i][j] = false;
                }
            }
        }

        int j = length - 1;
        while(j >= 0){
            boolean findWordEndAtJ = false;
            for(int i = 0; i < j; i++){

                if(isWord[i][j]){
                    findWordEndAtJ = true;
                    if(i == 0){
                        return true;
                    }
                    j = i - 1;
                    break;
                }
            }
            if(!findWordEndAtJ){
                return false;
            }

        }
        return false;
    }

    public boolean isWord(String s, List<String> wordDict, int i, int j){
        if(wordDict.indexOf(s.substring(i, j + 1)) != -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int maxL = 0;
        int minL = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for(String w : wordDict) {
            maxL = w.length() > maxL ? w.length() : maxL;
            minL = w.length() < minL ? w.length() : minL;
            set.add(w);
        }
        return wordBreak(s, set, minL, maxL);

    }

    private boolean wordBreak(String s, Set<String> set, int minL, int maxL) {
        int i = 0;
        for(int j = minL; j <= maxL && i + j - 1 < s.length(); j++) {
            if(set.contains(s.substring(i, i + j))) {
                if(i + j == s.length()) return true;
                else if(wordBreak(s.substring(i + j), set, minL, maxL)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        String s = "catsandog";
        List<String> wordDict = Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"});
        System.out.println(test.wordBreak2(s, wordDict));
    }

}
