package _7_斐波那契数列;

/**
 * 斐波那契数列数列从第3项开始,每一项都等于前两项之和。
 * 例子:数列 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n <= 39
 */
public class Solution {
    public int Fibonacci(int n) {
        //sum代表第0个元素 j代表第1个元素
        int sum = 0;
        int j = 1;

        //通过循环，是sum和j不断后移，但相对位置不变
        for (int i = 0;i < n;i++){
            j += sum;
            sum = j - sum;
        }

        return sum;
    }

    /**
     * 递归方式 -- 不够好
     */
//    public int Fibonacci(int n) {
//        if (n == 0)
//            return 0;
//        else if (n <= 2)
//            return 1;
//        else
//            return Fibonacci(n-1) + Fibonacci(n - 2);
//    }
}
