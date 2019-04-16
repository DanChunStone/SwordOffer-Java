package _64_滑动窗口的最大值;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3；
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>(num.length-size+1);
        if (num.length==0 || size == 0 || size > num.length)
            return result;

        int n = num.length - size + 1;
        for (int i = 0;i < n;i++){
            int max = num[i];

            for (int j = 1;j < size;j++)
                if (num[i + j] > max)
                    max = num[i + j];

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] x = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> result = new Solution().maxInWindows(x,3);

        for (int each:result)
            System.out.println(each);
    }
}
