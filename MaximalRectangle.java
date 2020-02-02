package main.java.leetCode;

import java.util.Stack;

/**
 * Created by qiuqian on 2/2/20.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // compute the maximum heights and update dp with it
                    dp[j] = dp[j] + 1;
                } else {
                    dp[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, computeByRow(dp));
        }

        return maxArea;
    }

    // compute the maximum area for rectangles with bottom line at a row
    private int computeByRow(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() >= 0 && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() >= 0) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
