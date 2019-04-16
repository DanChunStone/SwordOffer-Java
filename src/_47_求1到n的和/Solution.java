package _47_求1到n的和;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution {
    /**
     * 利用&&符号的短路特性结束递归
     */
//    public int Sum_Solution(int n) {
//        int sum = n;
//        boolean ans = (n>0) && ((sum = n + Sum_Solution(n-1)) > 0);
//        return sum;
//    }

    /**
     * 利用异常捕获机制结束递归
     */
    public int Sum_Solution(int n) {
        try {
            int x = 1 / n;
        }catch (Exception e){
            return 0;
        }

        return n + Sum_Solution(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Sum_Solution(5));
    }
}
