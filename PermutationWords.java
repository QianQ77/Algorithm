package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 1/8/19.
 */
public class PermutationWords {

    static int maxLength = 5;

    public static List<String> permutation(char[] chars) {
        List<String> words = new ArrayList<>();
        helper(words, chars, new StringBuilder());

        return words;
    }

    private static void helper(List<String> words, char[] chars, StringBuilder sb) {
        if (sb.length() <= maxLength) {
            words.add(sb.toString());
            if (sb.length() == maxLength) return;
        }

        for (char c : chars) {
            sb.append(c);
            helper(words, chars, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a','c','e','m','t','u'};
        List<String> result = permutation(chars);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
