package _21_栈的压入弹出;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序。
 * 请判断第二个序列是否可能为该栈的弹出顺序，假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 报错用例：[1,2,3,4,5],[3,5,4,2,1]
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 辅助栈
        Stack<Integer> stack = new Stack<>();
        // 记录push数组查找到的位置
        int start = 0;
        // 记录pop数组当前匹配的元素
        int i = 0;

        /**
         * 思路：对于A[1,2,3,4,5] -> B[3,5,4,2,1]
         * 将A中的元素压入栈中，并匹配B中需要匹配的元素(初始为第一个)
         * 若匹配成功，将栈顶元素与B中下一个元素匹配，匹配成功即弹出，知道匹配失败为止
         * A中所有元素入栈之后，若栈不为空，则说明匹配失败
         */
        while (start < pushA.length){
            stack.push(pushA[start]);

            if (pushA[start]==popA[i]) {
                while (!stack.empty() && i < popA.length && stack.peek()==popA[i]){
                    stack.pop();
                    i++;
                }
            }
            start++;
        }
        if (stack.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,4,5};
        int[] y = {3,5,4,2,1};

        System.out.println(new Solution().IsPopOrder(x,y));
    }
}
