package _32_数组排成最小的数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String result = "";
        if (numbers==null || numbers.length == 0)
            return result;

        // 将所有元素放入ArrayList中
        ArrayList<Integer> list = new ArrayList<>();
        for (int each : numbers)
            list.add(each);

        /**
         * 重写ArrayList的比较函数：compare
         * 对于每个数，将其转换为String，然后从最高位向低位开始比较大小
         * 若有一位数不相等，则返回这一位数的比较结果
         * 若其中一个数已经到达尾部：如3211与32，则32重新从最高位3与3211的第三位1开始比较
         */
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2)
                    return o1.compareTo(o2);

                String a = String.valueOf(o1);
                String b = String.valueOf(o2);
                int n = Math.max(a.length(),b.length());

                for (int i = 0;i < n;i++){
                    Integer n1 = Integer.valueOf(a.charAt(i%a.length()));
                    Integer n2 = Integer.valueOf(b.charAt(i%b.length()));
                    if (n1 != n2){
                        return n1.compareTo(n2);
                    }
                }
                return 0;
            }
        });

        // 将排序后的结果组合
        for (int each:list)
            result = result + each;

        return result;
    }
}
