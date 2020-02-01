package main.java.leetCode;

/**
 * Divide and Conquer
 * Use Segment Tree for optimizing complexity of finding min from O(n) at worse to O(log n)
 * Created by qiuqian on 2/1/20.
 */
public class LargestRectangleInHistogram {


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        SegmentTreeNode root = buildSegmentTree(heights, 0, heights.length - 1);

        return helper(heights, 0, heights.length - 1, root);
    }

    private int helper(int[] heights, int i, int j, SegmentTreeNode root) {
        if (i == j) {
            return heights[i];
        } else if (i > j) {
            return 0;
        }

        int minIdx = findMinIdx(root, i, j, heights);
        int maxArea = heights[minIdx] * (j - i + 1);
        maxArea = Math.max(maxArea, helper(heights, i, minIdx - 1, root));
        maxArea = Math.max(maxArea, helper(heights, minIdx + 1, j, root));
        return maxArea;
    }

    private int findMinIdx(SegmentTreeNode root, int left, int right, int[] arr) {
        if (root == null || root.end < left || root.start > right) {
            return -1;
        }
        if (left <= root.start && right >= root.end) {
            return root.minIdx;
        }
        int leftMinIdx = findMinIdx(root.left, left, right, arr);
        int rightMinIdx = findMinIdx(root.right, left, right, arr);
        if (leftMinIdx == -1) {
            return rightMinIdx;
        }
        if (rightMinIdx == -1) {
            return leftMinIdx;
        }
        return arr[leftMinIdx] > arr[rightMinIdx] ? rightMinIdx : leftMinIdx;
    }

    private SegmentTreeNode buildSegmentTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.minIdx = start;
            return root;
        }
        int middle = start + (end - start) / 2;
        root.left = buildSegmentTree(arr, start, middle);
        root.right = buildSegmentTree(arr, middle + 1, end);
        root.minIdx = arr[root.left.minIdx] < arr[root.right.minIdx] ? root.left.minIdx :  root.right.minIdx;
        return root;
    }

    private class SegmentTreeNode {
        int start;
        int end;
        int minIdx;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int maxArea = new LargestRectangleInHistogram().largestRectangleArea(heights);
        final int expected = 10;
        if (maxArea != expected) {
            System.out.println("Wrong answer. Actual: " + maxArea + "; Expected: " + expected);
        } else {
            System.out.println("Pass");
        }
    }
}
