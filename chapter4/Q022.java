package chapter4;

import structure.Stack;

/**
 * Created by tc on 9/5/16. 栈的压入,弹出序列
 * 输入两个整数序列,第一个序列表示栈的压入顺序,请判断第二个序列是否为该栈的弹出序列
 * 例如:序列 1,2,3,4,5 是某栈的压栈序列,序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列,但 4,3,5,1,2 就不可能是该压栈序列的弹出序列
 */
public class Q022 {

    public static void main(String[] args) {

        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 5, 3, 2, 1};
        int[] wrongPopOrder = {4, 3, 5, 1, 2};

        System.out.println(isPopOrder(pushOrder, popOrder));
        System.out.println(isPopOrder(pushOrder, wrongPopOrder));
    }

    /**
     * 判断第二个序列是否是第一个序列的出栈序列
     *
     * @param pushOrder 入栈序列
     * @param popOrder  出栈序列
     */
    private static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || pushOrder.length == 0 || popOrder == null || popOrder.length == 0) {
            return false;
        }

        if (pushOrder.length != popOrder.length) {
            return false;
        }

        Stack<Integer> assistStack = new Stack<>();//辅助栈
        Stack<Integer> mStack = new Stack<>();//存储入栈序列

        for (int p = pushOrder.length - 1; p >= 0; p--) {
            mStack.push(pushOrder[p]);
        }

        for (int i = 0; i < popOrder.length; i++) {
            int popTop = popOrder[i];

            while (!mStack.isEmpty()) {
                int stackTop = mStack.pop();
                assistStack.push(stackTop);
                if (stackTop == popTop) {
                    break;
                }
            }

            if (assistStack.pop() != popTop) {
                return false;
            }
        }
        return true;
    }
}
