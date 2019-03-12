package _9_变态跳台阶;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
    // 思路：n阶时，他的情况为它后退1阶、2阶、3阶...n-1阶的情况数量之和
    // 由于n-1阶的情况也为前面n-2阶的数量之和，故n阶的情况数为：n-1阶情况数*2
    public int JumpFloorII(int target) {
        if (target == 1){
            return target;
        }

        int sum = 1;
        for (int i = 2;i <= target;i++){
            sum *= 2;
        }

        return sum;
    }
}
