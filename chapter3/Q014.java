package chapter3;

/**
 * Created by tc on 9/1/16. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组,实现一个函数来调整该数组中数字的顺序
 * 使得所有奇数位于数组的前半部分,所有的偶数位于数组的后半部分
 */
public class Q014 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reorder(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    /**
     * 联想到快速排序寻找切分点的方法
     * 分别从数组开始位置和数组终点位置向中间遍历
     * 从前向后遍历,直到寻找到一个偶数,从后向前遍历,直到找到一个奇数
     */
    private static void reorder(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int beginIndex = 0;
        int endIndex = arr.length - 1;

        while (beginIndex < endIndex) {
            while ((arr[beginIndex] & 0x1) != 0) {//向后移动索引,直到找到一个偶数
                beginIndex++;
            }
            while ((arr[endIndex] & 0x1) == 0) {//向前移动,直到找到一个奇数
                endIndex--;
            }
            if (beginIndex < endIndex) {//交换两个数
                int temp = arr[beginIndex];
                arr[beginIndex] = arr[endIndex];
                arr[endIndex] = temp;
            }
        }
    }
}
