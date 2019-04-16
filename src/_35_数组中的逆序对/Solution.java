package _35_数组中的逆序对;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 */
public class Solution {

    /**
     * 思路：
     * 本题使用归并排序的思想，将数组递归分割成前后两份，处理排序之后再递归合并
     * 由于本题所求为前面大的数与后面小的数的组合对数
     * 故一个数组分成前后两部分之后，若两个部分内部的组合已经求过
     * 则两个部分内部的元素顺序打乱对两个部分组合之后求 大-小数 对数没有影响，因为前一部分中更大的数仍然在后面一部分小的数的前面
     * 如：[3 2 1][6 5 2]排序之后[1 2 3][2 5 6],前面的3仍然在后面的2的前面
     */
    private static final int mod = 1000000007;
    public static int count;
    public int InversePairs(int[] array) {
        count = 0;
        if (array == null || array.length == 0)
            return count;

        separate(array,0,array.length-1);

        return count;
    }

    // 分割指定数组
    public static void separate(int[] array,int start,int end){
        if (start >= end)
            return;

        // 分成前后两部分求解
        int mid = (start+end) >> 1;
        separate(array,start,mid);
        separate(array,mid+1,end);

        // 将两部分合并求解
        merge(array,start,mid,end);
    }

    // 合并数组相邻子数组
    // 求前后两部分能组合出的 大-小数 数量，并将组合后的数组排序
    public static void merge(int[] array,int start,int mid,int end){
        // i,j分别记录两个子数组中最右(大)的元素
        int i = mid,j = end;

        // 记录临时排序结果
        int[] tem = new int[end-start+1];
        int index = tem.length-1;

        // 循环将两个数组中最大的数放入临时数组中的最后一个
        // [1 3 5 7][2 4 6 8]
        // 每次循环，若更大的数来自前半个数组，则此时，这个数能和后半个数组中还没有进入临时数组中的数组成逆序对
        // 故记录count应该增加后半个数组中未放入临时数组的元素数
        // 如[1 3 5| 7][2 4| 6 8],此时 5 > 4，则count应该增加2
        while (index >= 0){
            // 前半部分放完了，后半部分留下的数字都是比前半部分小
            // 但是在前半部分的数据入临时数组时，已经将剩下的这些数据能和前半部分数据组成的逆序对考虑进去
            if (i<start)
                tem[index--] = array[j--];
            // 后半部分放完了，前半部分留下的数字都比后半部分小(故，count不用增加)
            // 如[1 2 | 4 5 6] [|3 3 4 7] 无法组成逆序对
            else if (j <= mid)
                tem[index--] = array[i--];
            else{
                // 前面的数字比后面的数字大
                // 此时count增加后半数组中比当前参与比较的元素小的元素数量
                // 如 i->5,后半部分：[1 2 4 \ 6] j->4,count应增加3
                if (array[i] > array[j]){
                    tem[index--] = array[i--];
                    count += j - mid;
                    count = count % mod;
                }else {
                    tem[index--] = array[j--];
                }
            }
        }

        for (index = 0;index < tem.length;index++)
            array[start+index] = tem[index];

        tem = null;
    }


    public static void main(String[] args) {
        int[] x = {1,2,5,6,7,2,5};
        System.out.println(new Solution().InversePairs(x));
    }
}
