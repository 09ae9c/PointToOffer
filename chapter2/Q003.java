package chapter2;

/**
 * Created by tc on 8/16/16.二维数组中查找
 */
public class Q003 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        System.out.println("result is:" + find(matrix, 4, 4, 7));
    }


    private static boolean find(int[][] matrix, int rows, int cols, int number) {

        if (matrix == null || rows <= 0 || cols <= 0) {
            return false;
        }

        int row = 0;// 行从上到下
        int col = cols - 1;// 列从右到左

        while (row < rows && col >= 0) {
            if (matrix[row][col] == number) {
                return true;
            } else if (matrix[row][col] > number) {
                --col;
            } else {
                ++row;
            }
        }
        return false;
    }


}
