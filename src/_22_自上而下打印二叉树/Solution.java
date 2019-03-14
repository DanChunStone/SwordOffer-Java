package _22_自上而下打印二叉树;

import Tools.TreeNode;
import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

/**
 * 思路：
 * 通过一个结点队列，将root结点入队列
 * 然后每次出队列一个结点，并将该结点的元素加入元素数组
 * 将左右子结点按顺序加入结点队列，循环至队列为空为止。
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> treeQueue = new ArrayList<>();

        if (root==null)
            return list;

        treeQueue.add(root);
        while (!treeQueue.isEmpty()){
            TreeNode tem = treeQueue.remove(0);
            list.add(tem.val);

            if (tem.left!=null)
                treeQueue.add(tem.left);
            if (tem.right!=null)
                treeQueue.add(tem.right);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(2);
        root1.left = root3;
        root1.right = root4;

        System.out.println(new Solution().PrintFromTopToBottom(root1).toString());
    }
}
