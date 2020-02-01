package main.java.leetCode;

import main.java.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiuqian on 9/19/18.
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        HashMap<TreeNode, Integer> rootSum = new HashMap<TreeNode, Integer>();
        rootSum(rootSum, root);
        int result = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr;
        int size;
        while(!queue.isEmpty()) {
            size = queue.size();
            while(size > 0) {
                curr = queue.poll();
                int pathSum = curr.val;
                int left = 0;
                int right = 0;
                if(curr.left != null) {
                    queue.offer(curr.left);
                    left = Math.max(left, rootSum.get(curr.left));
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                    right = Math.max(right, rootSum.get(curr.right));
                }
                pathSum += left + right;
                result = Math.max(result, pathSum);
                size--;
            }

        }
        return result;
    }

    private int rootSum(HashMap<TreeNode, Integer> rootSum, TreeNode root) {
        if(root == null) {
            return 0;
        }
        int result = root.val;
        int left = Math.max(0, rootSum(rootSum, root.left));
        int right = Math.max(0, rootSum(rootSum, root.right));
        result = Math.max(result + left, result + right);
        rootSum.put(root, result);
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
        TreeNode root = TreeNode.getATree(new Integer[]{-10,9,20,null,null,15,7});
        System.out.println(test.maxPathSum(root));
    }
}
