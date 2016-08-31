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
     * 接下来利用全排列的思想,组合所有可能的位数
     */
    private static void print1ToMaxNDigits(int n) {

        if (n<=0){
            return;
        }
        char[] number=new char[n];

        for (int i=0;i<number.length;i++){//初始化字符串数组
            number[i]='0';
        }

        for (int i=0;i<10;i++){
            number[0]= (char) (i+'0');
            print1ToMaxOfNDigitsRecursively(number,0);
        }
    }


    private static void print1ToMaxOfNDigitsRecursively(char[] number,int index){
        int length=number.length;
        if (index==length-1){
            printNumber(number);
            return;
        }
        for (int i=0;i<10;i++){
            number[index+1]= (char) (i+'0');
            print1ToMaxOfNDigitsRecursively(number,index+1);
        }
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
