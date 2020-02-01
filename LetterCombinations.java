package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 11/18/18.
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return result;
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, result, new StringBuilder(), map, 0);
        return result;
    }

    private void dfs(String digits, List<String> result, StringBuilder sb, String[] map, int i) {
        if(i == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for(int j = 0; j < map[digits.charAt(i) - '0'].length(); j++) {
            sb.append(map[digits.charAt(i) - '0'].charAt(j));
            dfs(digits, result, sb, map, i + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations test = new LetterCombinations();
        System.out.println(test.letterCombinations("23"));
    }
}
