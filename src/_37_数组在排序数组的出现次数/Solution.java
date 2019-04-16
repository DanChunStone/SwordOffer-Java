package _37_数组在排序数组的出现次数;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int start = 0,end = array.length-1;
        int mid = 0;

        if (array==null || array.length==0)
            return 0;

        // 判断k是否出现在数组范围内
        if (k<array[0] || k>array[array.length-1])
            return 0;

        // 二分查找k出现的一个位置
        while (start < end){
            mid = (start+end+1)>>1;

            if (array[start] == k)
                mid = start;
            if (array[end] == k)
                mid = end;

            if (array[mid] > k)
                end = mid-1;
            else if (array[mid] < k)
                start = mid+1;
            else
                break;
        }

        // 若未找到k
        if (array[mid] != k)
            return 0;

        //从当前找到k的位置开始，往前后同时搜索，直到出现不等于k的元素或找到边界
        int count = 1;
        int i = mid+1,j = mid-1;
        while (i<array.length && array[i++]==k)
            count++;
        while (j>=0 && array[j--]==k)
            count++;

        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,5,5,5,6,7,8,9,9};
        new Solution().GetNumberOfK(x,5);
    }
}
