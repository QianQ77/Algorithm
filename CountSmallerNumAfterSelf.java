package main.java.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qiuqian on 1/4/19.
 */
public class CountSmallerNumAfterSelf {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int leNum;

        public TreeNode(int val, int leNum) {
            this.val = val;
            this.leNum = leNum;
        }
    }

    TreeNode insert(TreeNode root, int val, int parent_leNum) {
        if (root == null) {
            root = new TreeNode(val, parent_leNum + 1);
        }else if (root.val == val) {
            root.leNum++;
        }else if (root.val < val) {
            root.right = insert(root.right, val, root.leNum);
        } else {
            root.left = insert(root.left, val, 0);
            root.leNum++;
        }
        return root;
    }

    int query(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.val == val) {
            return root.leNum;
        }else if (root.val < val) {
            return root.leNum + query(root.right, val);
        } else {
            return query(root.left, val);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        TreeNode root = null;
        if (nums == null) return result;
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            result.add(query(root, nums[i] + 1));
            root = insert(root, nums[i], 0);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        CountSmallerNumAfterSelf test = new CountSmallerNumAfterSelf();
        System.out.println(test.countSmaller(nums));
    }
}
