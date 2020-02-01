package main.java.leetCode;

/**
 * Created by qiuqian on 9/22/17.
 */
public class LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        int result = 1;
        for(int i = n - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    int middle = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                    dp[i][j] = middle + 2;
                }else{
                    dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j - 1]);
                }
                result = Integer.max(dp[i][j], result);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence test = new LongestPalindromeSubsequence();
        System.out.println(test.longestPalindromeSubseq("bbbab"));
    }
}
