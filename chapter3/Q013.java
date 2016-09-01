package chapter3;

/**
 * Created by tc on 8/31/16. 在 O(1)时间内删除链表节点
 *
 * 给定单向链表的头指针和一个节点指针,定义一个函数在 O(1) 时间删除改节点
 */
public class Q013 {
    private static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value=value;
            this.next=null;
        }
    }

    public static void main(String[] args){
        Node head=new Node(1);
        Node two=new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        head.next=two;
        two.next=three;
        three.next=four;

        deleteNode(head,two);
    }

    /**
     * 删除指定节点的思路:找到要删除节点的下一个节点,将其复制到要删除的节点
     */
    private static void deleteNode(Node head,Node toBeDeleted){
        if (head==null||toBeDeleted==null){
            return;
        }

        if (toBeDeleted.next!=null){
            Node next=toBeDeleted.next;
            toBeDeleted.value=next.value;
            toBeDeleted.next=next.next;
            next=null;
        }else if (head==toBeDeleted){
            head=null;
            toBeDeleted=null;
        }else {
            Node node = head;
            while (node.next!=toBeDeleted){
                node=node.next;
            }
            node.next=null;
            toBeDeleted=null;
        }
    }
}
