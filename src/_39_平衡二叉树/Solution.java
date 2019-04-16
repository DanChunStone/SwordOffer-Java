package _39_平衡二叉树;

import Tools.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution {
    /**
     * 根据题意，似乎只需要判断二叉树的（平衡特性），即左右子树深度相差不超过1
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;
    }

    // 求左右子树的深度，若相差不超过1，则返回实际深度，否则返回-1（代表不符合平衡二叉树）
    public static int getDepth(TreeNode root){
        if (root==null)
            return 0;

        // 求左子树深度，若为-1，则直接返回-1并停止搜索
        int left = getDepth(root.left);
        if (left == -1)
            return -1;

        int right = getDepth(root.right);
        if (right == -1)
            return -1;

        int x = Math.abs(right-left);
        if (x>1)
            return -1;

        return Math.max(right,left)+1;
    }
}
