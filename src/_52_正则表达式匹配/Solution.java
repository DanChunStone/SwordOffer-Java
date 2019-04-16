package _52_正则表达式匹配;

import java.util.Stack;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        return matchByIndex(str,pattern,0,0);
    }

    public static boolean matchByIndex(char[] str, char[] pattern, int str_index, int pat_index){
        // str和pattern都空了
        if (str.length <= str_index && pattern.length <= pat_index)
            return true;
        // str没空，pattern空了
        if (str_index < str.length && pat_index >= pattern.length)
            return false;

        // 下一个字符为*
        if (pat_index+1 < pattern.length && pattern[pat_index+1] == '*'){
            if (str_index < str.length && (str[str_index]==pattern[pat_index] || pattern[pat_index]=='.')){
                return matchByIndex(str,pattern,str_index,pat_index+2) || matchByIndex(str,pattern,str_index+1,pat_index);
            }else {
                return matchByIndex(str,pattern,str_index,pat_index+2);
            }
        // 下一个字符不为*
        }else {
            // 若当前字符串不为空，且字符串字符能匹配模式串中的字符
            if (str_index < str.length && (str[str_index]==pattern[pat_index] || pattern[pat_index]=='.'))
                return matchByIndex(str,pattern,str_index+1,pat_index+1);
            else
                return false;
        }
    }

    public static void main(String[] args) {
        char[] str = "a".toCharArray();
        char[] pattern = ".".toCharArray();

        System.out.println(new Solution().match(str,pattern));
    }
}
