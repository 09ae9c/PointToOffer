package chapter2;

/**
 * Created by tc on 2016/8/18.替换空格
 * 在字符串中，将所有空格替换成 %20
 */
public class Q004 {

    public static void main(String[] args) {
        String data = "We are happy.";
        System.out.println(change(data));
    }

    /**
     * 思路：首先获取原始字符串中的空格个数，然后创建一个新的数组，新数组长度为原始字符创长度加上空格个数*2(因为要替换成 %20，每个空格就多了两个位置的字符)
     * 然后从后往前遍历数组，遇到空格就替增加三个字符，否则将原始字符串对应的值赋值给字符数组中对应的位置
     */
    private static String change(String origin) {

        int blankCount = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == ' ') {
                blankCount++;
            }
        }
        char[] newChars = new char[origin.length() + blankCount * 2];

        int originIndex = origin.length() - 1;
        int newCharIndex = newChars.length - 1;
        while (newCharIndex >= 0) {
            if (origin.charAt(originIndex) == ' ') {
                newChars[newCharIndex--] = '0';
                newChars[newCharIndex--] = '2';
                newChars[newCharIndex--] = '%';
            } else {
                newChars[newCharIndex--] = origin.charAt(originIndex);
            }
            originIndex--;
        }

        return String.valueOf(newChars);
    }
}