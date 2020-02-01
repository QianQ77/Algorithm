package main.java.leetCode;

import main.java.util.TreeNode;

import java.util.Arrays;

/**
 * Created by qiuqian on 9/7/18.
 */
public class ConstructBinaryTreeFromPreorderAndInorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = Arrays.binarySearch(inorder, preorder[0]);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftInorder.length, preorder.length);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;

    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        buildTree(preorder, inorder);
    }

}
