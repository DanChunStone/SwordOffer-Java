package _1_二维数组中查找;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int column = array[0].length;

        int i = 0;
        int j = column - 1;
        while(i <= row-1 && j >= 0){
            if(array[i][j] > target){
                j--;
            }else if(array[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
