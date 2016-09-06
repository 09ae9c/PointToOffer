package chapter4;

/**
 * Created by tc on 9/6/16.复杂链表的复制
 * 实现函数复制一个复杂链表,在复杂链表中,每个节点除了有一个 next 指向下一个节点外,还有一个 sibling 指向链表中任意节点或者 null
 */
public class Q026 {

    private static class Node{
        int value;
        Node next;
        Node sibling;

        public Node(int value){
            this.value=value;
            this.next=null;
            this.sibling=null;
        }

    }


    public static void main(String[] args){

    }


    private static Node clone(Node root){
        return null;
    }

}
