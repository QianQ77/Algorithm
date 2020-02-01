package main.java.leetCode;

import java.util.List;

/**
 * Created by qiuqian on 8/12/18.
 */
public class WordBreakBruteforce {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0) {
            return false;
        }

        for(String word: wordDict) {
            String[] strings = s.split(word);
            if(strings.length == 1 && strings[0] == s) {
                continue;
            }
            if(wordBreak(strings, wordDict)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String[] strings, List<String> wordDict) {
        for(String string: strings) {
            if(string.length() == 0) {
                continue;
            }
            if(!wordBreak(string, wordDict)) {
                return false;
            }
        }
        return true;
    }
}
