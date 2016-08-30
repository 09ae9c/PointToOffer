package chapter2;

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
     * @param base     底数
     * @param exponent 次方
     */
    public static double power(double base, int exponent) throws Exception {

        if (Double.compare(base, 0.0) == 0 && exponent < 0) {
            throw new Exception("invalid input");
        }

        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }

        double result = powerWithExponent(base, absExponent);

        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private static double powerWithExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithExponent(base, exponent >> 1);

        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

}
