package _46_圆圈中最后剩下的数;

/**
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class Solution {
    /**
     * 使用一个数组模拟环
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1)
            return -1;

        // 记录孩子数的数组
        int[] child = new int[n];
        // 记录当前到达的下标
        int index = 0;
        // 经过的没离开的孩子数
        int step = 0;
        // 当前剩下的孩子数量
        int childNum = n;

        // 当环内还有孩子没离开时
        while (childNum > 0){
            // 跳过所有已经离开了的孩子
            while (child[index%n]==1)
                index++;

            // 经过了一个还在环内的孩子
            step++;
            // 若已经经过了m个在环内的孩子，则让该孩子离开
            if (step == m){
                child[index%n] = 1;
                step = 0;
                childNum--;
            }
            index++;
        }

        return (index-1)%n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().LastRemaining_Solution(5,3));
    }
}
