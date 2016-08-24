package chapter2;

/**
 * Created by tc on 2016/8/23.旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组末尾，称之为数组旋转。
 * 输入一个递增排序的数组的一个旋转，例如原数组为{1,2,3,4,5}，某一个旋转为{3,4,5,1,2}
 * 现在要在这个旋转的数组中寻找最小的元素，上述旋转后的数组中，最小元素为 1
 * 最简单的方法是遍历数组，寻找最小的元素，但是这里可以利用二分查找的思想做到更好
 */
public class Q008 {

    public static void main(String[] args){
        try {
            int[] arr1 = {3,4,5,1,2};
            System.out.println("输入的数组是升序排序数组的一个旋转结果："+min(arr1));

            int[] arr2 = {3,4,4,1,2};
            System.out.println("输入的数组中有重复元素结果："+min((arr2)));

            int[] arr3 = {1};
            System.out.println("输入的数组只包含一个数组结果："+min(arr3));

            int[] arr4 =null;
            System.out.println("输入 null 的结果："+min(arr4));

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    /**
     * 对递增排序数组的旋转数组进行查找，寻找最小元素
     * 这样的数组存在的特点：数组开头元素大于等于最后的元素
     * 如果中间元素值大于开头元素，则最小值元素一定位于中间元素右边
     * 如果中间元素值小于最后元素，则最小值元素一定位于中间元素左边
     * 根据这个思路不断二分的查找，就能找到最小元素
     */
    private static int min(int[] arr) throws Exception {
        if (arr==null||arr.length==0){
            throw new Exception("输入错误");
        }

        int index1=0;
        int index2=arr.length-1;

        int indexMid=index1;
        while (arr[index1]>=arr[index2]){
            if (index2-index1==1){
                indexMid=index2;
                break;
            }

            indexMid = index1+(index2-index1)/2;

            //如果 index1，index2 和 indexMid 相等，则只能顺序查找
            if (arr[index1]==arr[index2]&&arr[indexMid]==arr[index1]){
                return minInArr(arr);
            }

            if (arr[indexMid]>arr[index1]){//如果中间元素值大于开头元素，则最小元素在中间元素右边
                index1=indexMid;
            }else if (arr[indexMid]<arr[index2]){//如果中间元素值小于最后元素，则最小元素在中间元素左边
                index2=indexMid;
            }
        }
        return arr[indexMid];
    }

    /**
     * 顺序遍历数组，找到最小值元素（特殊情况处理）
     */
    private static int minInArr(int[] arr){
        int min = arr[0];

        for (int i=1;i<arr.length;i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
