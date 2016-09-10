package chapter5;

/**
 * Created by tc on 9/10/16.连续子数组的最大和
 * <p>
 * 输入一个整型数组,数组里有正数也有负数,数组中一个或连续多个整数组成一个子数组,求所有子数组的和的最大值
 * 例如输入数组{1,-2,3,10,-4,7,2,-5},和最大的连续子数组为{3,10,-4,7,2},因此输出该子数组的和 18
 */
public class Q031 {

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubArray(nums));
    }

    /**
     * 思路:
     * 每一步累加和,如果当前和小于 0 ,则说明之前的步骤使得和变成了负数(此时如果再累加当前步骤的数,结果肯定小于当前步骤的数),所以不要之前的和
     * 直接令当前和为当前步骤的数,否则累加和.并把当前步骤的和赋值给最大和
     */
    private static int findGreatestSumOfSubArray(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int currentSum = 0;
        int greatestSum = 0;

        for (int i : numbers) {
            if (currentSum <= 0) {
                currentSum = i;
            } else {
                currentSum += i;
            }
            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
        }
        return greatestSum;
    }


}
