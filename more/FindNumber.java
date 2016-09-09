package more;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tc on 9/9/16.输入一个数组,找出其中出现次数最多的数并求和
 * 例如{1,2,3,1,4,8,2,2,4,5,2}其中出现次数最多的数是 2,出现了 4 次,和是 8
 */
public class FindNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 1, 4, 8, 2, 2, 4, 5, 2};

        System.out.println(findMostTimeNum(numbers));
    }


    private static int findMostTimeNum(int[] numbers) {

        Map<Integer, Integer> mMap = new HashMap<>();

        for (int i : numbers) {

            if (mMap.containsKey(i)) {
                int temp = mMap.get(i);
                mMap.put(i, temp + 1);
            } else {
                mMap.put(i, 1);
            }
        }

        int maxTimes = 0;
        int maxNum = 0;

        for (Integer i : mMap.keySet()) {

            if (mMap.get(i) > maxTimes) {
                maxTimes = mMap.get(i);
                maxNum = i;
            }
        }

        return maxNum * maxTimes;
    }


}
