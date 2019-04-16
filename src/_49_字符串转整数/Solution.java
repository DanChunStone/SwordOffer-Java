package _49_字符串转整数;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Solution {
    public int StrToInt(String str) {
        // 记录结果
        int sum = 0;

        // 判空
        if (str == null || str.length() == 0)
            return sum;

        // 记录正负符号
        int symbol = 1;

        /**
         * 从字符串的左边循环到右边，记录的前面各位之和乘以10再加上当前位数字
         * 一旦遇到非数字，返回0
         */
        for (int i = 0;i < str.length();i++){
            char c = str.charAt(i);

            if (c>='0' && c<='9')
                sum = sum*10 + (c-'0');

            // 若非数字出现在首位，判断是不是正负号
            else if (i == 0){
                if (c == '+')
                    symbol = 1;
                else if (c == '-')
                    symbol = -1;
                else
                    return 0;
            }else {
                return 0;
            }
        }

        return sum * symbol;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().StrToInt("-123"));
    }
}
