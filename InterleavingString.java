package main.java.leetCode;

/**
 * Created by qiuqian on 7/28/17.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        if(s1.length() == 0){ //Error Point
            return s2.equals(s3);
        }
        if(s2.length() == 0){
            return s1.equals(s3);
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for(int i = 1; i <= s1.length(); i++){
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));    //error point: dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1)
            for(int j = 1; j <= s2.length(); j++){
                dp[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
                dp[i][j] = false;
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }

            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args){
        InterleavingString is = new InterleavingString();
        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";
        System.out.println(is.isInterleave(s1, s2, s3));
    }
}
