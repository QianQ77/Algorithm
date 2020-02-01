package main.java.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 8/12/18.
 */
public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        if(wordDict == null || wordDict.size() == 0) {
            return results;
        }

        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        boolean[][] isWord = new boolean[s.length() + 1][s.length() + 1];

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= i; j++) {
                if(!canBreak[i - j]) {
                    continue;
                }
                if( wordDict.indexOf(s.substring(i - j, i)) != -1) {
                    isWord[i - j][i] = true;
                    canBreak[i] = true;
                }
            }
        }

        generateStrings(s.length(), s, results, new ArrayList<String>(), canBreak, isWord);

        return results;
    }

    public static void generateStrings(int current, String s, List<String> results, List<String> path, boolean[]
            canBreak,
                                 boolean[][] isWord) {
        if (current == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            if(path.size() > 0) {
                for(int i = path.size() - 1; i >= 0; i--) {
                    stringBuilder.append(path.get(i)).append(" ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                results.add(stringBuilder.toString());
            }

            return;
        }

        if(!canBreak[current]) {
            return;
        }

        for(int i = current - 1; i >= 0; i--) {
            if(canBreak[i] && isWord[i][current]) {
                path.add(s.substring(i, current));
                generateStrings(i, s, results, path, canBreak, isWord);
                path.remove(path.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList(new String[]{"cat","cats","and","sand","dog"});

        List<String> strings = WordBreakII.wordBreak(s, wordDict);
        for(String string : strings) {
            System.out.println(string);
        }

    }
}
