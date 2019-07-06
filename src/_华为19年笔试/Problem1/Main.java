package _华为19年笔试.Problem1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 读取数据
        int[] number = new int[6];
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        String[] num = string.substring(1,string.length()-1).split(",");

        for (int i = 0;i < 6;i++)
            number[i] = Integer.valueOf(num[i]);

        // 从小到大排序
        Arrays.sort(number,0,6);

        if (getMaxHours(number)){
            System.out.println("" + number[0] + number[1] + ":" + number[2] + number[3] + ":" + number[4] + number[5]);
            return;
        }
        System.out.println("invalid");
    }

    // 获取最大可组成的小时，6个整数
    public static boolean getMaxHours(int[] numbers){
        // 从大到小组合，这样第一个匹配的合法时间即最大合法时间
        for (int i = 5;i >= 0;i--){
            for (int j = 5;i != j && j >= 0;j--){
                if (numbers[i]*10+numbers[j]<=24){
                    // 尝试交换位置，搜索能否生成合法时间
                    exchange(numbers,0,i);
                    exchange(numbers,1,j);

                    // 该组合能找到合法时间组合
                    if (getMaxMinutes(numbers))
                        return true;

                    // 这一组合无法生成合法时间，将位置换回
                    exchange(numbers,0,i);
                    exchange(numbers,1,j);
                }
            }
        }

        return false;
    }

    // 获取最大可组成的分钟，后4个整数
    public static boolean getMaxMinutes(int[] numbers){
        Arrays.sort(numbers,2,6);

        for (int i = 5;i >= 2;i--){
            for (int j = 5;i != j && j >= 2;j--){
                if (numbers[i]*10+numbers[j]<=60){
                    // 尝试交换位置，搜索能否生成合法时间
                    exchange(numbers,2,i);
                    exchange(numbers,3,j);

                    // 该组合能找到合法时间组合
                    if (getMaxSecends(numbers))
                        return true;

                    // 这一组合无法生成合法时间，将位置换回
                    exchange(numbers,2,i);
                    exchange(numbers,3,j);
                }
            }
        }

        return false;
    }

    // 获取最大可组成的秒数，后2个整数
    public static boolean getMaxSecends(int[] numbers){
        int x = numbers[4]*10+numbers[5];
        int y = numbers[5]*10+numbers[4];

        if (x >= y){
            if (x <= 60)
                return true;
            else if (y <= 60){
                exchange(numbers,4,5);
                return true;
            }
        }else {
            if (y <= 60){
                exchange(numbers,4,5);
                return true;
            }else if (x <= 60)
                return true;
        }

        return false;
    }

    public static void exchange(int[] numbers,int x,int y){
        int tmp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = tmp;
    }
}
