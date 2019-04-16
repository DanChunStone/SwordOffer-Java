package _51_构建乘积数组;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Solution {
    /**
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
     * 将其分成两部分：A[0]*A[1]*...*A[i-1]  与  A[i+1]*...*A[n-1]
     * 第一个循环计算前半部分，第二个循环计算后半部分
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0)
            return new int[0];

        int[] b = new int[A.length];
        b[0] = 1;

        // b[i] = A[0]*A[1]*...*A[i-1]
        for (int i = 1;i < A.length;i++){
            b[i] = b[i-1] * A[i-1];
        }

        // tem = A[i+1]*...*A[n-1]
        int tem = 1;
        for (int i = A.length-2;i >= 0;i--){
            tem *= A[i+1];
            b[i] *= tem;
        }

        return b;
    }
}
