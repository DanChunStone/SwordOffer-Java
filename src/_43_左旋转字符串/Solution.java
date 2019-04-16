package _43_左旋转字符串;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str.length()==0)
            return "";

        int length = str.length();
        n = n%length;
        StringBuilder s = new StringBuilder(length);

        for (int i = 0;i < length;i++){
            s.append(str.charAt((i+n)%length));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().LeftRotateString("abcXYZdef",3));
    }
}