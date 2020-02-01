package main.java.leetCode;

import main.java.util.TreeNode;

import java.util.LinkedList;

/**
 * Created by qiuqian on 8/19/17.
 */
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        int result = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pop();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                result += findTiltOfNode(node);
            }
        }
        return result;
    }

    public int findTiltOfNode(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = sumOfSub(node.left);
        int rightSum = sumOfSub(node.right);
        return Math.abs(leftSum - rightSum);

    }

    public int sumOfSub(TreeNode node){
        if(node == null){
            return 0;
        }
        return sumOfSub(node.left) + node.val + sumOfSub(node.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        System.out.println(new BinaryTreeTilt().findTilt(root));
    }
}
