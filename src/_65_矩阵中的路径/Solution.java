package _65_矩阵中的路径;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Solution {
    private static char[] Matrix,Str;
    private static int Rows,Cols;
    private static boolean[][] path;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length==0 || rows==0 || cols==0 || str.length==0)
            return false;

        // 将参数写入对象
        Matrix = matrix;Str = str;
        Rows = rows;Cols = cols;
        path = new boolean[rows][cols];

        for (int i = 0;i < rows;i++)
            for (int j = 0;j < cols;j++){
                if (hasUsefulPath(i,j,0))
                    return true;
            }

        return false;
    }

    private static boolean hasUsefulPath(int x,int y,int n){
        // 字符串已经匹配完成
        if (n >= Str.length)
            return true;

        // 判断下标越界或者该位置已经走过了
        if (x < 0 || x >= Rows || y < 0 || y >= Cols || path[x][y])
            return false;

        // 若当前字符可以匹配
        int index = x*Cols+y;
        if (Matrix[index] == Str[n]){
            path[x][y] = true;

            if (hasUsefulPath(x+1,y,n+1) || hasUsefulPath(x,y+1,n+1)
                    || hasUsefulPath(x-1,y,n+1) || hasUsefulPath(x,y-1,n+1))
                return true;
        }
        path[x][y] = false;

        return false;
    }
}
