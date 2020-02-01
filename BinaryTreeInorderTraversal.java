package main.java.leetCode;

import main.java.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qiuqian on 9/6/18.
 */
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(node.left != null) {
                stack.push(node.left);
            } else {
                stack.pop();
                result.add(node.val);
                if(node.right != null) {
                    stack.push(node.right);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> list = BinaryTreeInorderTraversal.inorderTraversal(TreeNode.getATree_3());
        System.out.println(list);
    }
}
