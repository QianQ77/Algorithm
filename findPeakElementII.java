package main.java.leetCode;

/**
 * Created by qiuqian on 10/21/18.
 */
public class findPeakElementII {

    public static int[] find(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int startCol = 1;
        int endCol = M - 2;
        while(startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            int midRow = findMaxIndexInCol(A, midCol);
            if(A[midRow][midCol] > A[midRow][midCol + 1] && A[midRow][midCol] > A[midRow][midCol - 1]) {
                return new int[]{midRow, midCol};
            }
            if(A[midRow][midCol] > A[midRow][midCol + 1]) {
                endCol = midCol - 1;
            } else {
                startCol = midCol + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private static int findMaxIndexInCol(int[][] A , int col) {
        int maxIdx = 0;
        for(int i = 1; i < A.length - 1; i++) {
            if(A[i][col] > A[maxIdx][col]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        int[][] A = new int[][] {{1 ,2 ,3 ,6 ,5}, {16,41,23,22,6},
                {15,17,24,21,7}, {14,18,19,20,10}, {13,14,11,10,9}};
        int[] result = find(A);
        System.out.println(result[0] +","+ result[1]);
    }
}
