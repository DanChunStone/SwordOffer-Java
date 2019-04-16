package _60_二叉树打印成多行;

import Tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(10);
        if (pRoot==null)
            return result;

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(pRoot);

        // 遍历二叉树所有层
        while (!nodeList.isEmpty()){
            // 获取当前层结点个数，以及记录当前层元素值的数组
            int n = nodeList.size();
            ArrayList<Integer> values = new ArrayList<>(n);

            // 遍历当前层的每一个结点
            for (int i = 0;i < n;i++){
                TreeNode node = nodeList.pollFirst();
                values.add(node.val);

                // 将当前结点的子节点添加进队列，下一层进行遍历
                if (node.left!=null)
                    nodeList.addLast(node.left);
                if (node.right!=null)
                    nodeList.addLast(node.right);
            }

            result.add(values);
        }

        return result;
    }
}
