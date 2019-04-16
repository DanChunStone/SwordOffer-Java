package _59_之字形顺序打印二叉树;

import Tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树,即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot==null)
            return result;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(pRoot);
        boolean isOrder = true;

        // 循环遍历二叉树的每一层
        while (!list.isEmpty()){
            // 获取本层结点个数
            int n = list.size();
            // 记录本层结果
            ArrayList<Integer> value = new ArrayList<>(n);

            // 循环遍历本层的所有结点
            while (n > 0){
                TreeNode node = list.poll();

                // 顺序输出，则每一个值添加到队尾
                if (isOrder){
                    value.add(node.val);
                }else {// 逆序输出，则每一个值添加到队头
                    value.add(0,node.val);
                }

                // 将下一层的结点加入队列
                if (node.left!=null)
                    list.addLast(node.left);
                if (node.right!=null)
                    list.addLast(node.right);

                n--;
            }

            // 调转输出顺序
            isOrder = !isOrder;
            result.add(value);
        }

        return result;
    }
}
