package main.java.leetCode;

import java.awt.*;

/**
 * Created by qiuqian on 10/4/17.
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                int count = 0;

                int[] array = new int[]{-1, 0, 1};

                for(int k : array){
                    for(int t : array){
                        if(isValid(i + k, j + t, m, n)){
                            count++;
                            sum += M[i + k][j + t];
                        }
                    }
                }

                result[i][j] = sum / count;

            }
        }
        return result;
    }


    public boolean isValid(int row, int col, int m, int n){
        if(row < 0 || row >= m || col < 0 || col >= n){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 1, 1, 1},{1, 0, 1, 1},{1, 1, 1, 1},{1, 1, 1, 1}};
        ImageSmoother test = new ImageSmoother();
        int[][] result = test.imageSmoother(M);
        for(int[] line : result){
            for(int x : line){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
