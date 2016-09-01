package chapter3;

/**
 * Created by tc on 9/1/16. 反转链表
 * 定义一个函数,输入一个链表的头节点,反转该链表并输出反转后链表的头节点
 */
public class Q016 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


    public static void main(String[] args) {

        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        Node reverseNode = reverseList(head);

        System.out.println(reverseNode.value);
    }


    /**
     * 反转链表
     */
    private static Node reverseList(Node head) {

        Node node = head;
        Node reverseHead = null;
        Node preNode = null;

        while (node != null) {

            Node next = node.next;

            if (next == null) {//走到尾部
                reverseHead = node;
            }

            node.next = preNode;
            preNode = node;
            node = next;
        }
        return reverseHead;
    }
}
