package _腾讯19年实习笔试题;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int m = input.nextInt();
            int n = input.nextInt();
            int[] money = new int[n];

            for (int i = 0;i < n;i++)
                money[i] = input.nextInt();

            Arrays.sort(money);

            if (money[0]!=1) {
                System.out.println(-1);
                return;
            }

            System.out.println(findFix(m,money));
        }

        public static int findFix(int num,int[] money){
            int i = 0;
            while (i < money.length && money[i] < num)
                i++;
            i--;

            if (i==0)
                return num;

            int min = num;
            for (int j = i;j > 0;j--){
                int x = num/money[j] + findFix(money[j]-1,money);
                min = min > x?x:min;
            }

            return min;
        }
}
