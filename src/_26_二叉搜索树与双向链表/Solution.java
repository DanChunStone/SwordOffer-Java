package _26_二叉搜索树与双向链表;

import Tools.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution {

    //用于记录当前位置的前一个最左结点
    private TreeNode lastLeft = null;

    //传入根节点，返回这个子树转换成双向链表后的最左结点（即链表的开始结点）
    public TreeNode Convert(TreeNode pRootOfTree) {
        //判空
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            //若当前结点为叶子结点
            lastLeft = pRootOfTree;
            return pRootOfTree;
        }


        //获取左子树转换成链表后的头结点
        TreeNode left = Convert(pRootOfTree.left);

        //若左子树链表不为空，则将当前结点附到左子树最后结点（lastLeft）之后
        if (left!=null){
            lastLeft.right = pRootOfTree;
            pRootOfTree.left = lastLeft;
        }
        lastLeft = pRootOfTree; //最左结点指向当前结点

        //获取右子树转换成链表后的头结点
        TreeNode right = Convert(pRootOfTree.right);

        //若右子树链表不为空，则将右子树链表头结点跟在当前结点之后
        if (right!=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }

        //返回当前组合链表的头结点，若左子树为空，当前结点即头结点
        return left!=null?left:pRootOfTree;
    }

    public static void main(String[] args) {
//        10,6,14,4,8,12,16
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(14);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(16);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        new Solution().Convert(n1);
    }
}
