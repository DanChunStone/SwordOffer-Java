package _4_重建二叉树;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode = new TreeNode(pre[0]);

        int i = 0;
        while (in.length > i && in[i] != pre[0])
            i++;

        searchLeft(treeNode,pre,in,0,i);
        searchRight(treeNode,pre,in,i+1,in.length);

        return treeNode;
    }

    public void searchLeft(TreeNode t, int [] pre, int [] in, int startIndex, int endIndex) {
        if (startIndex == endIndex)
            return;

        // 顺序遍历前序数组，然后按顺序与指定部分的中序数组中对比
        // 一旦第一次出现两个数据相同，说明它为这一部分的数据的根节点
        for (int each : pre)
            for (int i = startIndex; i < endIndex; i++)
                if (each == in[i]){
                    TreeNode treeNode = new TreeNode(in[i]);
                    t.left = treeNode;

                    searchLeft(treeNode,pre,in,startIndex,i);
                    searchRight(treeNode,pre,in,i+1,endIndex);

                    return;
                }

    }

    public void searchRight(TreeNode t, int [] pre, int [] in, int startIndex, int endIndex) {
        if (startIndex == endIndex)
            return;

        for (int each : pre)
            for (int i = startIndex; i < endIndex; i++)
                if (each == in[i]){
                    TreeNode treeNode = new TreeNode(in[i]);
                    t.right = treeNode;

                    searchLeft(treeNode,pre,in,startIndex,i);
                    searchRight(treeNode,pre,in,i+1,endIndex);

                    return;
                }

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}