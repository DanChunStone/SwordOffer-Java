package _13_调整数组顺序;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * [2 3 5 1 6 8 9] -> [3 5 1 9 2 6 8]
 */
public class Solution {
    // 使用变种冒泡排序
    // 第i次循环，将从后往前数第i个偶数放到数组倒数第i个位置
    // 即每一次循环，将所有的偶数泡上升到上一个偶数下面的位置，若上面没有偶数，即浮到最上面
    public void reOrderArray(int [] array) {
        for (int i = 1;i < array.length;i++){
            for (int j = 0;j < array.length - i;j++){
                // 若当前位置为偶数，后一位置为奇数
                if (array[j] % 2 == 0 && array[j+1] % 2 != 0){
                    // 交换两个数位置
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                }
            }
        }
    }

    public boolean isEven(int x){
        if (x % 2 == 0)
            return true;
        return false;
    }
}
