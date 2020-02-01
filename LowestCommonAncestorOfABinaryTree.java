package main.java.leetCode;

import main.java.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 9/18/18.
 */
public class LowestCommonAncestorOfABinaryTree {
    static boolean foundOne = false;
    static TreeNode parent = null;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(new ArrayList<TreeNode>(), root, p, q);
        return parent;
    }
    private static void helper(List<TreeNode> path, TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return;
        }
        if(node.val == p.val || node.val == q.val) {
            if(foundOne) {
                return;
            } else {
                foundOne = true;
                parent = node;
            }
        }
        path.add(node);
        helper(path, node.left, p, q);
        helper(path, node.right, p, q);
        TreeNode removeNode = path.remove(path.size() - 1);
        if(parent != null && removeNode.val == parent.val) {
            parent = path.get(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.getATree(array);
        System.out.println(lowestCommonAncestor(root, new TreeNode(6), new TreeNode(4)));
    }
}
