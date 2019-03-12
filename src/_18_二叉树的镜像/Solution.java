package _18_二叉树的镜像;

import Tools.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：
 * 源二叉树：
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9  11
 * 镜像二叉树：
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7   5
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if (root==null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(2);
        root1.left = root3;
        root1.right = root4;

        TreeNode root2 = new TreeNode(5);

        System.out.println(new _17_树的子结构.Solution().HasSubtree(root1,root2));
    }
}
