package main.java.leetCode;

/**
 * Created by qiuqian on 8/22/18.
 */
public class LongestPalindrome {
    int maxLength = 0;

    public int longestPalindrome(String s) {
        if(s.length() < 2) {
            return s.length();
        }


        for(int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return maxLength;
    }

    public void extend(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if(end - start - 1 > maxLength) {
            maxLength = end - start -1;
        }
    }

    public String longestPalindrome2(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        String result = s.charAt(0) + "";
        int maxLength = 1;
        for(int mid = 0; mid < s.length(); mid++) {
            String expandStr = expand(s, mid, mid);
            if(expandStr.length() > maxLength) {
                result = expandStr;
                maxLength = expandStr.length();
            }
            expandStr = expand(s, mid, mid + 1);
            if(expandStr.length() > maxLength) {
                result = expandStr;
                maxLength = expandStr.length();
            }
        }
        return result;
    }

    private String expand(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(++start, end);
    }

    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        System.out.println(test.longestPalindrome2("aabbccccbdd"));
    }
}
