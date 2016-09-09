package chapter5;

/**
 * Created by tc on 9/9/16.数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半,找出这个数字
 * 例如输入一个数组{1,2,3,2,2,2,5,4,2},其中 2 出现了 5 次,超过数组长度的一半,因此输出 2
 */
public class Q029 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 2, 4};
        System.out.println(moreThanHalfNum(arr));
    }

    /**
     * 思路:
     * 在遍历的时候保存两个值:一个是数组中遍历到当前的数字,一个是次数;当遍历到下一个数字时,如果下一个数字和之前保存的数字相同,则次数加 1,
     * 如果下一个数字和之前保存的数字不同,则次数减 1,如果次数为零,需要保存下一个数字,并把次数设为 1,由于要找的数字出现次数比其他所有数字
     * 出现的次数之和都多,所以要找的数字肯定是最后一次把次数设为 1 时对应的数字
     */
    private static int moreThanHalfNum(int[] numbers) {

        if (numbers == null || numbers.length <= 0) {
            return 0;
        }

        int result = numbers[0];
        int times = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (times == 0) {
                result = numbers[i];
                times = 1;
            } else if (numbers[i] == result) {
                times++;
            } else {
                times--;
            }
        }

        if (!isMoreThanHalf(numbers, result)) {
            return 0;
        }
        return result;
    }


    /**
     * 检查数字在数组中出现次数是否超过数组长度
     */
    private static boolean isMoreThanHalf(int[] numbers, int num) {
        int times = 0;

        for (int i : numbers) {
            if (i == num) {
                times++;
            }
        }
        return times > numbers.length / 2;
    }
}
