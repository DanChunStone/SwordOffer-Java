package _66_机器人的运动范围;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动。
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution {
    private int threshold,rows,cols;
    private boolean[][] map;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <= 0)
            return 0;

        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        map = new boolean[rows][cols];

        return getMovingCount(0,0);
    }

    private int getMovingCount(int x,int y){
        if (x < 0 || x >= rows || y < 0 || y >= cols || map[x][y])
            return 0;

        // 计算行列坐标数位之和
        int count = 0;
        int X = x,Y = y;
        while (X!=0){
            count += X % 10;
            X = X / 10;
        }
        while (Y!=0){
            count += Y % 10;
            Y = Y / 10;
        }

        // 若坐标满足阈值范围
        if (count <= threshold){
            map[x][y] = true;
            return 1 + getMovingCount(x+1,y) + getMovingCount(x-1,y) + getMovingCount(x,y+1) + getMovingCount(x,y-1);
        }

        return 0;
    }
}
