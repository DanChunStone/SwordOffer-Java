package _27_字符串的排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution {
    /**
     * 思路：
     * 将传入的字符串转换成字符数组
     * 循环将字符数组的元素与首个元素调换位置，然后进入下一次递归
     * 下一次递归时，对1 -> n个元素进行同样的处理
     * 若当前元素已经为最后一个元素，则将当前顺序的字符数组转换成字符串计入结果
     * 最后对结果进行字典顺序的排序
     */
    private ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str!=null && str.length()>0) {
            char[] chars = str.toCharArray();
            combination(chars,0);
            Collections.sort(list);
        }
        return list;
    }

    public void combination(char[] chars,int i){
        // 判断当前是否为最后一个元素
        if (i == chars.length - 1){
            list.add(String.valueOf(chars));
            return;
        }

        // 用于记录已经交换到首位的字符，若出现重复字符，则跳过该字符
        Set<Character> set = new HashSet<>();
        // 循环当前范围内的字符，轮流放到首位
        for (int j = i;j < chars.length;j++){
            // 判断是否为重复字符
            if (!set.contains(chars[j])) {
                // 将遍历过的字符记录
                set.add(chars[j]);

                // 交换两个字符位置
                swap(chars, i, j);

                // 将处理字符的范围缩小，进入下一个递归
                combination(chars,i+1);

                // 判断完这种情况后，将字符换回
                swap(chars, i, j);
            }
        }
    }

    // 交换两个字符位置
    public void swap(char[] chas,int i,int j){
        char tem = chas[i];
        chas[i] = chas[j];
        chas[j] = tem;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new Solution().Permutation("abc");

        for (String s : strings)
            System.out.println(s);
    }
}