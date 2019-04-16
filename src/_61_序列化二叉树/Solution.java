package _61_序列化二叉树;

import Tools.TreeNode;


/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
/**
 * 思路：根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
 * 依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。
 * 当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
 * 另外，结点之间的数值用逗号隔开。
 */
public class Solution {
    String Serialize(TreeNode root) {
        if (root==null)
            return "#";

        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }

    // 分别记录当前序列化位置以及结点最大个数
    private static int n = 0;
    private static int maxNum = 0;

    TreeNode Deserialize(String str) {
        if ("".equals(str))
            return null;

        // 使用，进行分割，获取每个结点的值
        String[] nodes = str.split(",");
        maxNum = nodes.length;
        n = 0;

        return DeserializeTree(nodes);
    }

    private static TreeNode DeserializeTree(String[] nodes){
        // 若当前结点为空节点，直接返回
        if (nodes[n].equals("#")) {
            n++;
            return null;
        }

        // 若当前结点不为空结点，则序列化当前结点并递归序列化左右子节点
        TreeNode node = new TreeNode(Integer.valueOf(nodes[n++]));
        if (n < maxNum)
            node.left = DeserializeTree(nodes);
        if (n < maxNum)
            node.right = DeserializeTree(nodes);

        return node;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;

        System.out.println(new Solution().Deserialize("5,4,#,3,#,2").toString());
    }
}
