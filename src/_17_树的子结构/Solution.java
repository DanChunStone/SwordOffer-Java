package _17_树的子结构;


import Tools.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        // 判断同为空的情况
        if (root1==null || root2==null)
            return false;

        // 若当前结点值相同，则可以进一步尝试匹配子结构。
        boolean equal = false;
        if (root1.val == root2.val)
            equal = searchSubtree(root1.left,root2.left)&&searchSubtree(root1.right,root2.right);
        //若尝试向下匹配子结构成功，则表示查找成功
        if (equal)
            return equal;

        //若当前节点值不相等，则向树1的下面寻找
        return searchSubtree(root1.left,root2)||searchSubtree(root1.right,root2);
    }

    public static boolean searchSubtree(TreeNode root1, TreeNode root2){
        // 判断同为空的情况
        if (root2==null)
            return true;
        if (root1==null)
            return false;

        // 若当前结点值相同，则可以进一步尝试匹配子结构。
        boolean equal = false;
        if (root1.val == root2.val)
            equal = searchSubtree(root1.left,root2.left)&&searchSubtree(root1.right,root2.right);
        //若尝试向下匹配子结构成功，则表示查找成功
        if (equal)
            return equal;

        //若当前节点值不相等，则向树1的下面寻找
        return searchSubtree(root1.left,root2)||searchSubtree(root1.right,root2);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(2);
        root1.left = root3;
        root1.right = root4;

        TreeNode root2 = new TreeNode(5);

        System.out.println(new Solution().HasSubtree(root1,root2));
    }
}
