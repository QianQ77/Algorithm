package main.java.leetCode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/**
 * Created by qiuqian on 9/7/17.
 */
public class OutOfBoundaryPaths {

    int M = 1000000007;


    //int M=1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] memo=new int[m][n][N+1];
        for(int[][] l:memo)
            for(int[] sl:l)
                Arrays.fill(sl,-1);
        return findPaths(m,n,N,i,j,memo);
    }
    public int findPaths(int m, int n, int N, int i, int j,int[][][] memo) {
        if(i==m || j==n || i<0 ||j<0)
            return 1;
        if(N==0)
            return 0;
        if(memo[i][j][N]>=0)
            return memo[i][j][N];
        memo[i][j][N]=((findPaths(m,n,N-1,i-1,j,memo)+findPaths(m,n,N-1,i+1,j,memo))%M+(findPaths(m,n,N-1,i,j-1,memo)+findPaths(m,n,N-1,i,j+1,memo))%M)%M;
        return memo[i][j][N];
    }


/*
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] array = new int[m][n][N + 1];
        for(int p = 0; p < m; p++){
            for(int q = 0; q < n; q++){
                for(int t = 0; t <= N; t++){
                    array[p][q][t] = -1;
                }
            }
        }

        return findPathsHelper(m, n, N, i, j, array);
    }

    public int findPathsHelper(int m, int n, int k, int i, int j, int[][][] array){




        if(i < 0 || i >= m || j < 0 || j >= n){
            return 1;

        }
        if(k <= 0){
            return 0;
        }

        if(array[i][j][k] != -1){
            return array[i][j][k];
        }

        array[i][j][k] = findPathsHelper(m, n, k - 1, i - 1, j, array) + findPathsHelper(m, n, k - 1, i + 1, j, array) +
                findPathsHelper(m, n, k - 1, i, j - 1, array) + findPathsHelper(m, n, k - 1, i, j + 1, array);


        array[i][j][k] %= M;

        return array[i][j][k];

    }
*/
    public static void main(String[] args) {
        OutOfBoundaryPaths test = new OutOfBoundaryPaths();
        System.out.println(test.findPaths(50, 50, 50, 0, 0));


    }

}
