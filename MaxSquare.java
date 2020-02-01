package main.java.leetCode;

/**
 * Created by qiuqian on 9/22/17.
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int result = 0;
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0] - '0';
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j] - '0';
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){

                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    dp[i][j] = Integer.min(dp[i][j - 1], dp[i][j] );
                    dp[i][j] += 1;
                }

                result = Integer.max(dp[i][j], result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"10100","10111","11111","10010"};
        char[][] matrix = new char[strings.length][strings[0].length()];
        for(int i = 0; i < strings.length; i++){
            matrix[i] = strings[i].toCharArray();
        }
        MaxSquare test = new MaxSquare();
        System.out.println(test.maximalSquare(matrix));

    }
}
