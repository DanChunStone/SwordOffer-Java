package _42_和为s的两个数字;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        // 记录结果
        ArrayList<Integer> result = new ArrayList<>(2);
        if (array==null || array.length==0)
            return result;

        /**
         * 由于数组为升序，则使用两个指针从头尾向中间靠拢
         * 找到的第一对和为sum的数，其乘积为所有结果中最小的
         */
        int start = 0,end = array.length-1;
        while (start < end){
            // 若头+尾大于结果，则尾指针往前移
            if (array[start]+array[end] > sum)
                end--;
            // 若头+尾小于结果，则头指针往后移
            else if (array[start]+array[end] < sum)
                start++;
            else {
                result.add(array[start]);
                result.add(array[end]);
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,7,11,15};
        ArrayList<Integer> x = new Solution().FindNumbersWithSum(a,15);

        System.out.println(x.get(0)+","+x.get(1));
    }
}
