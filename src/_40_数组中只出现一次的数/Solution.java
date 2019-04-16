package _40_数组中只出现一次的数;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    /**
     * 思路：
     * 根据异或运算的性质：两个相同的数异或为0，一个数与0异或等于本身
     * 则将数组中的所有元素异或，结果为两个不同的数的异或结果，且肯定不为零
     * 则找出结果中第一位为1的位数，根据原理，两个数的这一位肯定一个为0一个为1
     * 然后通过这一位的数值，将数组分成两部分，然后在异或，两个结果即要找的两个数。
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array==null||array.length==0)
            return;

        // tem记录所有数的异或结果
        int tem = 0;
        for (int each:array)
            tem = tem^each;

        // n记录tem右移多少位后出现第一个非零位
        int n = 0;
        while (tem!=0){
            // 若tem最低位为1
            if ((tem&1)!=0)
                break;

            tem = tem>>1;
            n++;
        }

        // 循环遍历数组
        for (int each:array){
            // 若当前元素的第n位为0，则两个数中的一个包含在此
            if (((each>>n)&1)==0){
                num1[0] ^= each;

            // 若当前元素的第n位为1，则两个数中的另一个包含在此
            }else {
                num2[0] ^= each;
            }
        }
    }
}
