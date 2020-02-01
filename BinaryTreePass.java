package main.java.leetCode;
import main.java.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 12/10/17.
 */
public class BinaryTreePass {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }

        dfs(result, "", root);
        return result;
    }

    void dfs(ArrayList<String> result, String string, TreeNode node) {

        if(node.left == null && node.right == null) {
            result.add(string + node.val);
            return;
        }
        if(node.left != null) {
            dfs(result, string + node.val + "->", node.left);
        }
        if(node.right != null) {
            dfs(result, string + node.val + "->", node.right);
        }

    }
}
