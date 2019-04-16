package _50_数组中重复的数字;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Solution {
    // numbers:输入数组，length:数组长度，duplication[0]:第一个重复的数字，返回值:这个数是否存在
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length < 2)
            return false;

        // 由于所有数在0到n-1的范围内，则使用一个长度为n的数组记录每个数出现的情况
        boolean[] x = new boolean[length];
        for (int i = 0;i < length;i++){
            // 若当前数已经出现过，则直接返回
            if (x[numbers[i]]){
                duplication[0] = numbers[i];
                return true;
            }

            // 否则，将该数记录为已经出现过
            x[numbers[i]] = true;
        }

        return false;
    }
}
