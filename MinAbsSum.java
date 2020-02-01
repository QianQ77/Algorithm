package main.java.leetCode;

import java.util.Arrays;

/**
 * Created by qiuqian on 9/21/18.
 */
public class MinAbsSum {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] sum = new int[A.length];
        sum[0] = A[0];
        //sum[i] means the sum of 0th item to ith item
        int result = Math.abs(A[0]);
        for(int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
            result = Math.min(result, Math.abs(sum[i]));
        }
        //n^2
        for(int j = 1; j < A.length; j++) {
            for(int i = 0; i < j; i++) {
                result = Math.min(result, Math.abs(sum[j] - sum[i]));
            }
        }
        //nlog(n)
        Arrays.sort(sum);
        for(int i = 1; i < A.length; i++) {
            result = Math.min(result, sum[i] - sum[i - 1]);
        }

        return result;

    }
}
