package _44_翻转单词顺序;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution {
    public String ReverseSentence(String str) {
        if (str.trim().equals(""))
            return str;

        StringBuilder sb = new StringBuilder(str.length());
        // 获取所有单词
        String[] words = str.split(" ");
        // 记录当前需要添加的单词位置
        int wordIndex = words.length-1;

        for (int i = str.length()-1;i >= 0;i--){
            // 若当前位置的字符不为空格，则循环到下一个空格位置
            // 并将记录位置的单词添加进结果
            if (str.charAt(i)!=' '){
                while (i >= 0 && str.charAt(i)!=' ')
                    i--;
                sb.append(words[wordIndex--]);
            }

            // 判断当前位置（包括上面循环后的情况）是否为空格
            if (i >= 0 && str.charAt(i)==' ')
                sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ReverseSentence("I am a student."));
    }
}
