package _62_二叉搜索树的第k个结点;

import Tools.TreeNode;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class Solution {
    /**
     * 思路：二叉搜索树的中序遍历即结点从小到大排序的结果
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null || k==0)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        TreeNode node = pRoot.left;

        while (node!=null || !stack.isEmpty()){
            if (node==null){
                node = stack.pop();
                k--;
                if (k==0)
                    return node;
                node = node.right;
            }else {
                stack.push(node);
                node = node.left;
            }
        }

        return null;
    }
}
