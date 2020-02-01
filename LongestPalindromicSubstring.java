package main.java.leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiuqian on 3/12/17.
 */
public class LongestPalindromicSubstring {

    private int low, maxLength=0;

    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }

        for(int i = 0; i < s.length(); i++){
            extend(s, i, i);
            extend(s, i, i+1);
        }

        return s.substring(low, low+maxLength);



    }

    public void extend(String s, int m, int n){
        while(m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)){
            m--;
            n++;
        }


        int length = n-m-1;
        if(length >  maxLength){
            maxLength = length;
            low = m + 1;
        }
    }


    public String longestPalindrome2(String s) {

        if(s == null || s.length() <= 1) {
            return s;
        }
        //error: result should not be new String(); should be s.charAt(0)
        String result = s.charAt(0) + "";

        for (int i = 0; i < s.length(); i++) {
            result = check(s, i - 1, i + 1, result);
            result = check(s, i, i + 1, result);

        }
        return result;

    }

    private String check(String s, int start, int end, String result) {
        if(start < 0 || end >= s.length()) {
            return result;
        }
        while(start >= 0 && end < s.length()) {
            if(s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
        }
        if(end - start - 1 > result.length()) {
            result = s.substring(start + 1, end);
        }
        return result;

    }

    public static void main(String[] args){
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        String result = test.longestPalindrome2("bssbb");
        System.out.println(result);
    }

}
