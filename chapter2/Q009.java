package chapter2;

/**
 * Created by tc on 2016/8/23.斐波那契数列
 * 写一个函数，输入 n，求斐波那契数列的第 n 项
 * 公式：
 * { 0 (n=0)
 * f(n) = { 1 (n=1)
 * { f(n-1) + f(n-2)
 */
public class Q009 {

    public static void main(String[] args) {

        //功能测试
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(10));

        //边界值测试
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));

        //性能测试
        System.out.println(fibonacci(40));
        System.out.println(fibonacci(100));
    }

    private static long fibonacci(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;

        //递归实现，虽然简单直观，但是性能问题比较严重，因此不采用递归形式的算法
//        return fibonacci(n-1)+fibonacci(n-2);

    }
}
