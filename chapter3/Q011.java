package chapter3;

/**
 * Created by tc on 8/30/16.数值的整数次方
 * 实现库函数 double power(double base,int exponent),求 base 的 exponent 次方
 * 不需要考虑大数问题
 * <p>
 * 公式:
 * <p>
 * { a^(n/2)*a^(n/2)           n 为偶数
 * a^n =
 * { a^((n-1)/2)*a^((n-1)/2)*a n 为奇数
 */
public class Q011 {
    public static void main(String[] args) {
        try {
            System.out.println(power(2,1));
            System.out.println(power(-2,1));
            System.out.println(power(0,1));

            System.out.println(power(2,2));
            System.out.println(power(2,-2));
            System.out.println(power(2,0));

            System.out.println(power(-2,-2));
            System.out.println(power(0,-2));

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    /**
     * 思路:首先做非法输入判断,如果输入的底数为 0,并且指数为负数时,对 0 求倒数没有意义,因此要特殊处理
     * 接着求指数绝对值次方,按照公式递归求解,然后根据指数的正负,决定是否需要求倒数
     *
     * @param base     底数
     * @param exponent 次方
     */
    public static double power(double base, int exponent) throws Exception {

        if (Double.compare(base, 0.0) == 0 && exponent < 0) {
            throw new Exception("invalid input");
        }

        // 得到指数的绝对值
        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }

        double result = powerWithExponent(base, absExponent);

        // 如果指数为负数,则对结果求倒数
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    /**
     * 用递归的思想求指数
     *
     * 例如求 2 的 31 次方,计算过程是:
     *
     *    求2的15次方      ->   求2的(15/2)次方    ->    求2的(7/2)次方   ->   求2的(3/2)次方
     *                                                                           |
     *                                                                           V
     *  返回 128*128*2    <-     返回8*8*2       <-      返回2*2*2      <-       返回2
     *
     */
    private static double powerWithExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        //指数循环除以 2 求结果
        double result = powerWithExponent(base, exponent >> 1);

        result *= result;

        // 如果指数是奇数,还需要额外乘一次底数
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

}
