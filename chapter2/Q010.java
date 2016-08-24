package chapter2;

/**
 * Created by tc on 8/24/16. 二进制中 1 的个数
 * 输入一个整数,输出该数的二进制表示中 1 的个数
 * 例如输入 9 ,其二进制表示为 1001,则输出为 2
 */
public class Q010 {

    public static void main(String[] args) {

        //正数
        System.out.println(countOf1(1));
        System.out.println(countOf1(0x7FFFFFFF));
        //负数
        System.out.println(countOf1(0x80000000));
        System.out.println(countOf1(0xFFFFFFFF));
        //0
        System.out.println(countOf1(0));
    }

    /**
     *思路:一个整数减 1,再和原来的整数做与运算,会把该整数最右边的一个 1 变成 0
     * 例如一个整数 12,其二进制表示为 1100, 12-1==11(二进制为 1011),然后 11 再跟 12 进行与操作,结果为 1000
     * 这样,结果中就少了一个 1(原来是 1100,现在是 1000),这样循环,直到整个二进制表示中没有 1(结果为 0)
     */
    private static int countOf1(int num) {

        int count = 0;
        while (num != 0) {
            count++;
            num = (num - 1) & num;
        }
        return count;
    }
}
