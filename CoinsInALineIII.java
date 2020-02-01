package main.java.leetCode;

/**
 * Created by qiuqian on 11/11/18.
 */
public class CoinsInALineIII {

    public static boolean firstWin(int[] values) {
        int N = values.length;
        int[][][] dp = new int[N][N][2];
        int chooseLeft;
        int chooseRight;
        for(int i = N - 1; i >= 0; i--) {
            dp[i][i] = new int[]{values[i], 0};
            for(int j = i + 1; j < N; j++) {
                chooseLeft = values[i] + dp[i + 1][j][1];
                chooseRight = values[j] + dp[i][j - 1][1];
                if(chooseLeft >= chooseRight) {
                    dp[i][j] = new int[]{chooseLeft, dp[i + 1][j][0]};
                }else {
                    dp[i][j] = new int[]{chooseRight, dp[i][j - 1][0]};
                }
            }
        }
        return dp[0][N - 1][0] >= dp[0][N - 1][1];
    }

    public static boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        if(n <= 1) return true;

        // dp[i][j] = maximum value current player can get
        // between start = i, end = j
        int[][] dp = new int[n][n];

        dp[0][0] = values[0];
        dp[n - 1][n - 1] = values[n - 1];

        int sum = 0;
        for(int num : values){
            sum += num;
        }

        return 2 * memoizedSearch(0, n - 1, values, dp) > sum;
    }

    private static int memoizedSearch(int start, int end, int[] values, int[][] dp){
        if(start > end) return 0;
        if(dp[start][end] != 0) return dp[start][end];

        int takeLeft = values[start]
                + Math.min(memoizedSearch(start + 2, end, values, dp),
                memoizedSearch(start + 1, end - 1, values, dp));

        int takeRight = values[end]
                + Math.min(memoizedSearch(start + 1, end - 1, values, dp),
                memoizedSearch(start, end - 2, values, dp));

        dp[start][end] = Math.max(takeLeft, takeRight);
        return dp[start][end];
    }

    public static void main(String[] args) {
        int[][] valuess = {{32,12,2,4,1,3,53,5,17,24,13,21,5,18,20}, {1}, {1,2}, {34,1,23,21,35,64,63,1}};
        for(int[] values : valuess) {
            System.out.println(firstWin(values) == firstWillWin(values));
        }

    }
}
