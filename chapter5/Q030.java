package chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tc on 9/9/16.最小的 K 个数
 * <p>
 * 输入 n 个整数,找出其中最小的 K 个数
 * 例如输入{4,5,1,6,2,7,3,8},则最小的 4 个数是{1,2,3,4}
 */
public class Q030 {

    public static void main(String[] args) {
        int[] numbers = {4, 5, 1, 6, 2, 7, 3, 8};

        findLeastNumbers(numbers, 4);
    }

    /**
     * 思路:
     * 首先创建一个大小为 K 的容器,先从输入中里面添加 K 个元素
     * 然后查找容器中的最大值,遍历输入,如果某个元素小于容器中的最大值,则替换它们,依此循环,最后容器中剩下的元素就是最小的 K 个
     * //
     * 这里用的 ArrayList 来实现,还可以用 "最大堆" 这种数据结构来实现
     */
    private static void findLeastNumbers(int[] numbers, int k) {

        if (numbers == null || numbers.length <= 0) {
            return;
        }

        List<Integer> leastArray = new ArrayList<>(k);

        for (Integer i : numbers) {
            if (leastArray.size() < k) {//首先填充容器
                leastArray.add(i);
            } else {
                int leastMax = findMax(leastArray);//查找容器中的最大值
                if (i < leastMax) {
                    leastArray.set(leastArray.indexOf(leastMax), i);//替换
                }
            }
        }

        for (Integer i : leastArray) {
            System.out.print(" " + i);
        }
    }

    /**
     * 在 list 中查找最大值元素
     */
    private static int findMax(List<Integer> list) {

        int max = 0;

        for (Integer i : list) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }
}
