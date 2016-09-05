package chapter4;

import structure.MinStack;

/**
 * Created by tc on 9/4/16.包含 min 函数的栈
 * 定义栈的数据结构,在该类型中实现一个能够得到栈的最小元素的 min 函数,在该栈中,调用 min,push 及 pop 的时间复杂度都是 O(1)
 * 思路:通过定义一个辅助栈,每次入栈的同时,也会在辅助栈中添加一个元素,添加的规则是,如果当前要添加的元素小于辅助栈栈顶元素,则添加这个元素到
 * 辅助栈,否则,拷贝辅助栈栈定元素,添加到辅助栈,就是说,始终保持辅助栈栈顶元素最小
 * 详见 /structure/MinStack.java
 */
public class Q021 {


    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);

        System.out.println("min is:"+stack.min());
        try {
            stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("min is:"+stack.min());

        try {
            stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("min is:"+stack.min());
    }
}
