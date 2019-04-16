package _53_表示数值的字符串;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        if (str.length==0)
            return false;

        for (int i = 0;i < str.length;i++){
            if (str[i]=='e' || str[i]=='E'){
                return isDecimal(str,0,i-1) && isInteger(str,i+1,str.length-1);
            }
        }

        return isDecimal(str,0,str.length-1);
    }

    // 判断是否是合法整数，E/e后面跟的必须是合法整数
    public static boolean isInteger(char[] str,int start,int end){
        if (start > end)
            return false;

        boolean symbol = false;
        for (int i = start;i <= end;i++){
            if (str[i]=='+' || str[i]=='-'){
                // 若+/-符号已经出现过 或者 符号位不是出现在数字首位
                if (symbol || i > start)
                    return false;

                symbol=true;
            }else if (str[i] < '0' || str[i] > '9'){
                return false;
            }
        }

        return true;
    }

    // 判断是否是合法的十进制数，包括小数/整数情况。没有E/e或者E/e的前面部分，必须是合法的十进制数
    public static boolean isDecimal(char[] str,int start,int end){
        if (start > end)
            return false;

        boolean symbol = false,point = false;
        for (int i = start;i <= end;i++){
            if (str[i]=='+' || str[i]=='-'){
                // 若+/-符号已经出现过 或者 符号位不是出现在数字首位
                if (symbol || i > start)
                    return false;

                symbol=true;
            } else if (str[i] == '.'){
                if (point)
                    return false;
                point=true;
            } else if (str[i] < '0' || str[i] > '9'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[] str = "12e+4.3".toCharArray();
        System.out.println(new Solution().isNumeric(str));
    }
}