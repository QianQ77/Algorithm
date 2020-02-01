package main.java.leetCode;

/**
 * Created by qiuqian on 10/5/18.
 */
public class RegularExpressionMatch {
    public static boolean isMatch(String s, String p) {
        if(s == null && p == null || s.length() == 0 && p.length() == 0) return true;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int j = 1; j <= p.length(); j++) {
            if(j % 2 == 1) dp[0][j] = false;
                //error point: should consider dp[0][j - 2];
            else dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*' && p.charAt(j - 2) != '*';
        }

        for(int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
            for(int j = 1; j <= p.length(); j++) {
                if(matchChar(s.charAt(i - 1), p.charAt(j - 1))) dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j - 1) != '*' || j == 1 || p.charAt(j - 2) == '*') dp[i][j] = false;
                else {
                    //error point: should not: dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || i > 1 && s.charAt(i - 1) == s.charAt(i - 2) && dp[i - 1][j];
                    //e.g. "ab" and ".*"
                    dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j] && matchChar(s.charAt(i - 1), p.charAt(j - 2));
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private static boolean matchChar(char cS, char cP) {
        return cP == '.' || cS == cP;
    }

    public static void main(String[] args) {
        //String s = "aasdfasdfasdfasdfas";
        //String p = "aasdf.*asdf.*asdf.*asdf.*s";
        //String s = "axxas";
        //String p = "ax.*x.*s";
        String s = "";
        String p = ".";
        System.out.println(isMatch(s, p));
    }
}
