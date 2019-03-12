package _10_矩形覆盖;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution {
    public int RectCover(int target) {
        if (target <= 2){
            return target;
        }

        int x2 = 1;
        int x1 = 2;
        int sum = 0;
        for (int i = 3;i <= target;i++){
            sum = x1 + x2;
            x2 = x1;
            x1 = sum;
        }
        return sum;
    }
}
