package _38_二叉树深度;

import Tools.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;

        int deep = 1;
        if (root.left!=null)
            deep += TreeDepth(root.left);
        if (root.right!=null)
            deep = Math.max(TreeDepth(root.right)+1,deep);

        return deep;
    }
}
