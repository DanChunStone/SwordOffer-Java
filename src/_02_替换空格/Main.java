package _02_替换空格;

import java.util.Scanner;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuffer str = new StringBuffer(input.nextLine());

        Main main = new Main();
        System.out.println(main.replaceSpace(str));
    }

    // 方法一、调用String.replace方法
//    public String replaceSpace(StringBuffer str) {
//        String string = new String(str);
//        return string.replace(" ","%20");
//    }

    public String replaceSpace(StringBuffer str){
        if (str == null || str.length()<=0){
            return "";
        }

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' ')
                string.append("%20");
            else
                string.append(str.charAt(i));
        }

        return string.toString();
    }
}
