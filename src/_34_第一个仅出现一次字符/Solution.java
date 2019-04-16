package _34_第一个仅出现一次字符;

import java.util.LinkedList;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str==null || str.equals(""))
            return -1;

        // 记录未出现重复的字符
        LinkedList<Character> queue1 = new LinkedList<>();
        // 记录出现了重复的字符
        LinkedList<Character> queue2 = new LinkedList<>();

        for (int i = 0;i < str.length();i++){
            char c = str.charAt(i);

            // 若该字符未在已重复链表中存在
            if (!queue2.contains(c)){
                // 若该字符已经在未重复链表中存在，则转移到已重复链表
                if (queue1.contains(c)){
                    queue1.remove((Character) c);
                    queue2.addLast(c);
                }else {
                    queue1.addLast(c);
                }
            }
        }

        return str.indexOf(queue1.getFirst());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().FirstNotRepeatingChar("googgle"));
    }
}
