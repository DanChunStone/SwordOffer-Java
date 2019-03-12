package 拼多多18年笔试题;

import java.util.Scanner;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 *
 * 输入描述:
 * 无序整数数组A[n]
 *
 * 输出描述:
 * 满足条件的最大乘积
 *
 * 输入例子1:
 * 3 4 1 2
 *
 * 输出例子1:
 * 24
 */
public class Problem1 {
    public static void main(String[] args) {
        int[] min = {0,0};
        int[] max = {0,0,0};

        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int x = input.nextInt();
            if (x < 0){
                if (x<min[1])
                    min[1] = x;
                if (x<min[0])
                {
                    min[1] = min[0];
                    min[0] = x;
                }
            }else {
                if (x>max[2])
                    max[2] = x;
                if (x>max[1]) {
                    max[2] = max[1];
                    max[1] = x;
                }
                if (x>max[0]){
                    max[1] = max[0];
                    max[0] = x;
                }
                System.out.println(""+max[2]+","+max[1]+","+max[0]);
            }
        }

        if (min[0]*min[1] > max[2]*max[1])
            System.out.println(min[0]*min[1]*max[0]);
        else
            System.out.println(max[0]*max[1]*max[2]);
    }
}
