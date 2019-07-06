package _08_跳台阶;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

public class Solution {
    //思路：当前台阶的跳法总数=当前台阶后退一阶的台阶的跳法总数+当前台阶后退二阶的台阶的跳法总数
    public int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }

        int sum = 0;
        int step1 = 2;  //当前位置后退一阶的跳法数
        int step2 = 1;  //当前位置后退两阶的跳法数

        for (int i = 3;i <= target;i++){
            sum = step1 + step2; //求第i阶跳法数

            //此时，step2为i-1阶的跳法数；step1为i阶跳法数
            step2 = step1;
            step1 = sum;
        }

        return sum;
    }



    public static void main(String[] args) {
        new Solution().JumpFloor(29);
    }
}
