package _30_连续子数组的最大和;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Solution {
    /**
     * 思路：
     * 采用动态规划，使用temSum记录循环到当前位置的最大子序列和
     * 若当前temSum为负，则temSum变为当前元素，否则加上当前元素
     * maxSum记录所有temSum中最大的情况，即为结果
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;

        int maxSum = array[0];
        int temSum = array[0];

        for (int i = 1;i < array.length;i++){
            if (temSum < 0)
                temSum = array[i];
            else
                temSum += array[i];

            if (temSum>maxSum)
                maxSum = temSum;
        }

        return maxSum;
    }
}
