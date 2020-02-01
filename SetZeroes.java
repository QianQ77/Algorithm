package main.java.leetCode;

/**
 * Created by qiuqian on 9/4/18.
 */
public class SetZeroes {
    public static void setZeroes(int[][] matrix) {

        if(matrix == null) {
            return;
        }
        boolean firstColZero = false;
        boolean firstRowZero = false;
        for(int i = 0; i < matrix.length; i++) {
            if(!firstColZero && matrix[i][0] == 0) firstColZero = true;
            for(int j = 0; j < matrix[0].length; j++) {
                if(!firstRowZero && matrix[0][j] == 0) firstRowZero = true;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstColZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if(firstRowZero) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        SetZeroes.setZeroes(matrix);
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
