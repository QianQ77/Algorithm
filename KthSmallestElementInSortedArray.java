package main.java.leetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by qiuqian on 10/12/18.
 */
public class KthSmallestElementInSortedArray {
    public int kthSmallest(int[][] matrix, int k) {
        return partition(matrix, k, 0, matrix.length * matrix.length - 1);

    }
    private int partition(int[][] matrix, int k, int start, int end) {
        int N = matrix.length;
        //int pivot_index = start + new Random().nextInt(end + 1 - start);
        int pivot_index = start;
        int pivot = matrix[pivot_index / N][pivot_index % N];

        int left = start;
        int right = end;
        int index = start;

        while(index <= right) {
            if(matrix[index / N][index % N] < pivot) {
                swap(matrix, left / N, left % N, index / N, index % N);
                index++;
                left++;
            } else if(matrix[index / N][index % N] == pivot) {
                index++;
            } else {
                swap(matrix, right / N, right % N, index / N, index % N);
                right--;
            }
        }
        if(k == right + 1) {
            return matrix[right/N][right%N];
        }else if(k > right + 1) {
            return partition(matrix, k, right + 1, end);
        }else {
            return partition(matrix, k, start, right - 1);
        }
    }

    private void swap(int[][] matrix, int i_r, int i_c, int j_r, int j_c) {
        int k = matrix[i_r][i_c];
        matrix[i_r][i_c] = matrix[j_r][j_c];
        matrix[j_r][j_c] = k;
    }

    public static void main(String[] args) {
        KthSmallestElementInSortedArray test = new KthSmallestElementInSortedArray();
        int[][] matrix = new int[][]{{4,7,11},{7,11,16},{10,11,20}};
        int k = 6;
        System.out.println(test.kthSmallest(matrix, k));
    }
}
