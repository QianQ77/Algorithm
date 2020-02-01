package main.java.leetCode;

import main.java.util.TreeNode;

import java.util.LinkedList;

/**
 * Created by qiuqian on 10/21/17.
 */
public class MinDepth {
    public static int minDepth(TreeNode root) {
        /*
        Error: note that the shortest path to the nearest leaf node.
        The following solution will return 1 when the input tree is [1,2]
        if(root == null){
            return 0;
        }
        return Integer.min(minDepth(root.left), minDepth(root.right)) + 1;
        */
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(node.right == null && node.left == null){
                    return depth;
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getATree_2();
        System.out.println(minDepth(root));

    }
}
