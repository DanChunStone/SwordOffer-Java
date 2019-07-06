package _华为19年笔试.Problem2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] costString = input.nextLine().split(",");
        String[] priceString = input.nextLine().split(",");

        // 获取参数
        int capital = input.nextInt();
        int[] cost = new int[costString.length];
        int[] price = new int[costString.length];


        System.out.println(costString.length);
        System.out.println(priceString.length);
        System.out.println(capital);
    }
}
