package _腾讯19年实习笔试题;

import java.util.Scanner;

public class Problem3 {
    private static int[] power;
    private static int[] money;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        power = new int[n];
        money = new int[n];

        for (int i = 0;i < n;i++)
            power[i] = input.nextInt();
        for (int i = 0;i < n;i++)
            money[i] = input.nextInt();

        System.out.println(findMinMoney(0,0));
    }

    static int findMinMoney(int position,long maxPower){
        if (position >= power.length)
            return 0;

        if (power[position] > maxPower){
            return findMinMoney(position+1,maxPower+power[position]) + money[position];
        }else {
            return Math.min(findMinMoney(position+1,maxPower+power[position]) + money[position],findMinMoney(position+1,maxPower));
        }
    }
}
