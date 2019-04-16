package _58_对称的二叉树;

import Tools.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;

        // 判断二叉树的左右子树是否对称
        return isEquals(pRoot.left,pRoot.right);
    }

    static boolean isEquals(TreeNode left,TreeNode right){
        // 若都为空，则对称
        if (left == null && right == null)
            return true;

        // 若两个子树都不为空，则判断元素值和子树是否对称
        if (left!=null && right!=null){
            // 判断这一个节点值是否相同
            if (left.val!=right.val)
                return false;

            // 判断（左边树的左子树与右边树的右子树）（左边树的右子树与右边树的左子树）的对称性
            return isEquals(left.left,right.right) && isEquals(left.right,right.left);
        }

        // 若有一个为空，一个不为空，则不对称
        return false;
    }
}
