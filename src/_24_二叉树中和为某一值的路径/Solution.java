package _24_二叉树中和为某一值的路径;

import Tools.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {
    // result记录所有路径，list用来记录当前路径
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * 思路:
     * target记录当前需要搜索路径之和的数值
     * 若target为0且搜索到了叶子结点，则搜索到了一条路径
     * 否则往左子树、右子树接着搜索
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return result;

        list.add(root.val);
        target -= root.val;
        if (target==0 && root.left == null && root.right == null)
            result.add(new ArrayList<>(list)); // 这里需要新建一个ArrayList，因为list的值后续会发生变化

        if (root.left != null)
            FindPath(root.left,target);
        if (root.right != null)
            FindPath(root.right,target);

        list.remove(list.size()-1); // 将当前搜索加入进去的值删除，表示回溯到上一层

        return result;
    }
}
