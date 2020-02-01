package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 8/22/18.
 */
public class PalindromePermutationII {

    public List<String> permutation(String s) {
        List<String> results = new ArrayList<>();
        if(s.length() <= 1) {
            results.add(s);
            return results;
        }
        int oddChar = -1;
        int[] chars = new int[256];
        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for(int i = 0; i < 256; i++) {
            if(chars[i] % 2 != 0) {
                if(oddChar != -1) {
                    return results;
                }else {
                    oddChar = i;
                }
            }
        }

        char[] palindrome = new char[s.length()];
        if(oddChar != -1) {
            palindrome[s.length() / 2] = (char) oddChar;
            chars[oddChar]--;
        }

        helper(results, palindrome, chars, s.length() / 2 - 1);

        return results;
    }

    private void helper(List<String> results, char[] palindrome, int[] chars, int index) {
        if(index < 0) {
            results.add(new String(palindrome));
            return;
        }
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != 0) {
                palindrome[index] = (char) i;
                palindrome[palindrome.length - index - 1] = (char) i;
                chars[i] -= 2;
                helper(results, palindrome, chars, index - 1);
                chars[i] += 2;
            }
        }
    }

    public static void main(String[] args) {
        PalindromePermutationII test = new PalindromePermutationII();
        System.out.println(test.permutation("abba"));
    }
}
