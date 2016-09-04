package chapter4;

/**
 * Created by tc on 9/3/16. 顺时针打印矩阵
 * 输入一个矩阵,按照从外向里以顺时针的顺序一次打印出每一个数字
 * 例如:
 * 1, 2, 3, 4
 * 5, 6, 7, 8
 * 9,10,11,12
 * 13,14,15,16
 * <p>
 * 打印出结果是:1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 */
public class Q020 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printMatrixClockWisely(matrix, 4, 4);
    }


    /**
     * 思路,将顺时针旋转打印分解成一圈一圈向中心递减的打印圈,每一圈的顺序是顺时针
     * 递减结束的标志是开始坐标在矩阵中心位置了
     * 比如 5*5 的矩阵,中心位置是 (2,2),递减圈有三个,开始坐标分别是(0,0),(1,1),(2,2),因此在 5*5 的矩阵中,需要循环 3 次画圈
     */
    private static void printMatrixClockWisely(int[][] matrix, int rows, int cols) {

        if (matrix == null || rows <= 0 || cols <= 0) {
            return;
        }

        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            printCircle(matrix, rows, cols, start);
            start++;
        }
    }

    /**
     * 打印一圈数字,顺序是这样的:
     *
     * 0----->0
     * ^      |
     * |      |
     * |      V
     * 0<-----0
     *
     */
    private static void printCircle(int[][] matrix, int rows, int cols, int start) {

        int endRows = rows - 1 - start;
        int endCols = cols - 1 - start;

        //从左到右打印一行
        for (int j = start; j < endCols; j++) {
            System.out.print(matrix[start][j] + " ");
        }

        //从上到下打印一列
        if (start < endRows) {
            for (int i = start + 1; i <= endRows; i++) {
                System.out.print(matrix[i][endCols] + " ");
            }
        }

        //从右到左打印一行
        if (start < endCols && start < endRows) {
            for (int j = endCols - 1; j >= start; j--) {
                System.out.print(matrix[endRows][j] + " ");
            }
        }

        //从下到上打印一列
        if (start < endCols && start < endRows - 1) {
            for (int i = endRows - 1; i >= start + 1; i--) {
                System.out.print(matrix[i][start] + " ");
            }
        }
    }
}
