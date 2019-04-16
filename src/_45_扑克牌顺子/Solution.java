package _45_扑克牌顺子;

import java.util.Arrays;

/**
 * “红心A,黑桃3,小王,大王,方片5”
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4)。
 * 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 */
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers==null || numbers.length==0)
            return false;

        // 排序
        Arrays.sort(numbers);

        int start = 0;
        while (numbers[start]==0)
            start++;
        // 0的个数
        int n = start;

        // 从第二个非0元素开始判断，若该数与前一个数的差大于1，则减去（差-1）个0
        // 若和前一个数相同，则返回false
        for (int i = start + 1;i < numbers.length;i++){
            if (numbers[i] - numbers[start] == 0)
                return false;

            n -= (numbers[i] - numbers[i-1]) - 1;
        }

        // 若0有剩余，则肯定为连续，否则不为连续
        return n >= 0;
    }

    public static void main(String[] args) {
        int[] x = {1,3,0,0,5};
        System.out.println(new Solution().isContinuous(x));
    }
}
