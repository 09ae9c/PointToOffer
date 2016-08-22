package chapter2;

import structure.Stack;

/**
 * Created by tc on 2016/8/22.用两个栈实现队列
 */
public class Q007 {

    private static Stack<Integer> stackA;
    private static Stack<Integer> stackB;

    public Q007(){
        stackA=new Stack<>();
        stackB=new Stack<>();
    }


    public static void main(String[] args){

    }


    public static void appendTail(int item){
        stackA.push(item);
    }

    public static void deleteHead(){

    }


}
