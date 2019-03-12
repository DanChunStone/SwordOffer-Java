package _12_数值的整数次方;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class Solution {
    public double Power(double base, int exponent) {
        double sum = 1;

        // 判断指数为0，若为0，值为1
        if (exponent == 0)
            return 1;
        // 指数为负数，基数为0的情况下，会导致分母为0，报错
        if (base == 0 && exponent < 0)
            throw new RuntimeException("error");

        // 将负数指数转成正数，负数指数的情况为正数指数情况下的倒数(1/sum)
        int n;
        if (exponent < 0)
            n = -exponent;
        else
            n = exponent;

        // 求base的n次方，先将n转为二进制，如：13 -> 1101
        // 因为 base^13 = base^1 * base^4 * base^8
        // 故通过循环判断指数n当前二进制位是否为1，将结果乘以base的相应次方
        // 循环结束，将指数右移一位：1101->110；并将base的次方翻倍：base -> base^2
        while (n!=0){
            if ((n&1) == 1)
                sum *= base;

            base *= base;
            n >>= 1;
        }

        if (exponent<0)
            sum = 1/sum;

        return sum;
    }
}
