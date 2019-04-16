package _腾讯19年实习笔试题;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String number = input.nextLine();
        number = input.nextLine();

        int numberOf1 = 0;
        int numberOf0 = 0;
        for (int i = 0;i < number.length();i++){
            if (number.charAt(i)=='0')
                numberOf0++;
            else
                numberOf1++;
        }

        System.out.println(Math.abs(numberOf0-numberOf1));
    }
}
