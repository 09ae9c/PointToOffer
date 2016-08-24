package chapter2;

import structure.Stack;

/**
 * Created by tc on 2016/8/22.用两个栈实现队列
 */
public class Q007 {

    private static class CQueue {
        private Stack<Integer> stackA;
        private Stack<Integer> stackB;

        public CQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void appendTail(int item) {
            stackA.push(item);
        }

        public int deleteHead() {
            if (stackB.size() <= 0) {
                while (stackA.size() > 0) {
                    stackB.push(stackA.pop());
                }
            }

            if (stackB.size() == 0) {
                return 0;
            }
            return stackB.pop();
        }
    }


    public static void main(String[] args) {
        CQueue cq = new CQueue();
        for (int i = 0; i < 10; i++) {
            cq.appendTail(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(cq.deleteHead());
        }

    }
}
