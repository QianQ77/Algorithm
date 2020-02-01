package main.java.leetCode;

/**
 * Created by qiuqian on 7/26/17.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return 0;
        }
        int[] minCut = new int[s.length() + 1];
        minCut[0] = -1;

        for(int i = 0; i < s.length(); i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j <= i; j++){
                if(isPalindrome(s, j, i)){
                    min = Math.min(min, minCut[j] + 1);
                }
            }


            minCut[i + 1] = min;
        }
        return minCut[s.length()];
    }


    public boolean isPalindrome(String s, int start, int end){
        for(int i = start, j = end; i <= j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
