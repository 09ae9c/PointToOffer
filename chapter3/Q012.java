package chapter3;

/**
 * Created by tc on 8/31/16. 打印 1 到最大的 n 位数
 * <p>
 * 输入数字 n,按顺序打印出从 1 到最大的 n 为十进制数,比如输入 3,则打印出 1,2,3...999(最大的三位数)
 * <p>
 * 注意本题陷阱:考虑大数问题
 */
public class Q012 {

    public static void main(String[] args) {
        print1ToMaxNDigits(1);
        print1ToMaxNDigits(2);
        print1ToMaxNDigits(3);

        print1ToMaxNDigits(-1);
        print1ToMaxNDigits(0);
    }


    /**
     * 由于需要考虑大数的处理,就不能使用 int 或 其它整型数据类型存放,因此用字符数组来存放每一位的数字
     * 接下来不断的进行模拟加法和打印数字这两个操作
     */
    private static void print1ToMaxNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];

        for (int i = 0; i < number.length; i++) {//初始化字符串数组
            number[i] = '0';
        }

        while (!increment(number)) {
            printNumber(number);
        }
    }

    /**
     * 对数字模拟加法运算
     */
    private static boolean increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;

        for (int i = nLength - 1; i >= 0; i--) {
            int mSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) {
                mSum++;
            }
            if (mSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    mSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + mSum);
                }
            } else {
                number[i] = (char) ('0' + mSum);
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 打印数字
     */
    private static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        for (char c : number) {
            if (isBeginning0 && c != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(c);
            }
        }
        System.out.println("\t");
    }
}
