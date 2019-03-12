package _19_顺时针打印矩阵;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如，如果输入如下4 X 4矩阵：
 * [ 1  2  3  4
 *   5  6  7  8
 *   9  10 11 12
 *   13 14 15 16 ]
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix==null)
            return result;

        int x1=0,y1=0,x2=matrix.length-1,y2=matrix[0].length-1;
        searchNumber(result,matrix,x1,y1,x2,y2);

        return result;
    }

    public static void searchNumber(ArrayList<Integer> result,int[][] matrix,int x1,int y1,int x2,int y2){
        if (x1 > x2 || y1 > y2)
            return;
        if (x1 == x2 && y1 == y2){
            result.add(matrix[x1][y1]);
            return;
        }

        for (int i = y1;i <= y2;i++)
            result.add(matrix[x1][i]);
        for (int i = x1+1;i <= x2;i++)
            result.add(matrix[i][y2]);
        for (int i = y2-1;i >= y1 && x2!=x1;i--)
            result.add(matrix[x2][i]);
        for (int i = x2-1;i >= x1+1 && y1!=y2;i--)
            result.add(matrix[i][y1]);

        searchNumber(result,matrix,x1+1,y1+1,x2-1,y2-1);
    }
}
