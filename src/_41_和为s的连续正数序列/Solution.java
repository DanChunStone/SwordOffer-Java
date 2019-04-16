package _41_和为s的连续正数序列;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列（至少两个数）。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 如：一组连续正数和为100的序列:18,19,20,21,22。
 */
public class Solution {
    /**
     * 思路：
     * 通过两个指针，划定求和范围，从1、2开始
     * 若范围内的数之和等于sum，则当前范围内的数组成一个答案
     * 若和小于sum，则范围上界+1，否则范围下界+1
     * 直到下界超过上界
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int low = 1,high = 2;
        while (low < high){
            int current = (high + low) * (high-low+1) / 2;

            if (sum == current){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low;i <= high;i++)
                    list.add(i);
                result.add(list);
                low++;
            }
            else if (sum > current){
                high++;
            }else {
                low++;
            }
        }

        return result;
    }
}
