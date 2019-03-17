package _23_二叉搜索树后序遍历;

/**
 * 输入一个整数数组，判断该数组是不是某(二叉搜索树)的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
    /**
     * 二叉搜索树的左子树元素都比根结点小，右子树元素都比根结点大
     * 故对于后序遍历结果，则取出数组最后一个元素x，数组的前面部分应分为两部分
     * 其中前面一部分都比x小，后面一部分都比x大。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length > 0)
            return VerifySquenceOfBSTByIndex(sequence,0,sequence.length-1);
        return false;
    }

    public static boolean VerifySquenceOfBSTByIndex(int [] sequence,int start,int end){
        if (start>=end)
            return true;

        int x = sequence[end];

        int i = start;
        while (sequence[i]<=x && i < end)
            i++;

        for (int j = i;j < end;j++){
            if (sequence[j] < x)
                return false;
        }

        return VerifySquenceOfBSTByIndex(sequence,0,i-1) && VerifySquenceOfBSTByIndex(sequence,i,end-1);
    }

    public static void main(String[] args) {
        int[] x = {4,8,6,12,16,14,10};
        System.out.println(new Solution().VerifySquenceOfBST(x));
    }
}