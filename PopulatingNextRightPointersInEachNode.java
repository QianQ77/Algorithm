package main.java.leetCode;

import main.java.util.TreeLinkNode;

/**
 * Created by qiuqian on 8/14/18.
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null && root.right != null) {
            root.left.next = root.right;
            connect(root.left);
            connect(root.right);
            TreeLinkNode rightmostInLeft = root.left;
            while(rightmostInLeft.right != null) {
                rightmostInLeft.right.next = rightmostInLeft.next.left;
                rightmostInLeft = rightmostInLeft.right;
            }
        }
    }
}
