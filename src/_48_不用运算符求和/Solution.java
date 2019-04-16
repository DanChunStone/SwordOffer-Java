package _48_不用运算符求和;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Solution {
    /**
     * 两个数异或：相当于每一位相加，而不考虑进位；
     * 两个数相与，并左移一位：相当于求得进位；
     * 将上述两步的结果相加即结果
     */
    public int Add(int num1,int num2) {
        // 循环求 和（忽略进位）与上一步进位的和，直到进位为0为止
        while (num2 != 0){
            // 求该步不考虑进位之和 以及 进位
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }

        return num1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Add(5,10));
    }
}
