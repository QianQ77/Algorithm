package main.java.leetCode;

import java.util.Stack;

/**
 * Use Stack;
 * We consider every element to be a candidate:
 * if ith element  is the shortest bar, what is the maximum area possible for all such rectangles?
 * the height is heights[i], the width should be (`right` - `left` - 1)
 * when `right` is the index of the first bar whose height is less than heights[i] in the right;
 * `left` is the index of the last bar whose height is less than heights[i] in the left.
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * Created by qiuqian on 2/1/20.
 */
public class LargestRectangleInHistogram_Stack {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() >= 0 && heights[stack.peek()] > heights[i]) {
                maxArea = Math.max(maxArea, helper(stack, i, heights));
            }
            stack.push(i);
        }

        while (stack.peek() >= 0) {
            maxArea = Math.max(maxArea, helper(stack, n, heights));
        }
        return maxArea;
    }

    /* calculate maxArea of rectangles in which the index of the shortest bar is at the top of stack */
    private int helper(Stack<Integer> stack, int right, int[] heights) {
        int height = heights[stack.pop()];
        return height * (right - stack.peek() - 1);
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int maxArea = new LargestRectangleInHistogram_Stack().largestRectangleArea(heights);
        final int expected = 10;
        if (maxArea != expected) {
            System.out.println("Wrong answer. Actual: " + maxArea + "; Expected: " + expected);
        } else {
            System.out.println("Pass");
        }
    }
}
