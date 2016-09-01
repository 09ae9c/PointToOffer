package chapter3;

/**
 * Created by tc on 9/1/16. 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表,合并这两个链表并使新链表中的节点仍然是按照递增排序的
 * 例如由链表 1 和链表 2 合并得到链表 3:
 * 链表 1: 1 -> 3 -> 5 -> 7
 * 链表 2: 2 -> 4 -> 6 -> 8
 * 链表 3: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
 */
public class Q017 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        //链表 1: 1 -> 3 -> 5 -> 7
        one.next = three;
        three.next = five;
        five.next = seven;

        //链表 2: 2 -> 4 -> 6 -> 8
        two.next = four;
        four.next = six;
        six.next = eight;

        Node node = merge(one, two);

        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }


    /**
     * 合并两个排序的链表
     */
    private static Node merge(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node mergedHead;

        //如果链表 1 的头节点值小于链表 2 的头节点值,就将合并后的链表指向链表 1 的头节点,反之则指向链表 2 的头节点
        if (head1.value <= head2.value) {
            mergedHead = head1;
            mergedHead.next = merge(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = merge(head1, head2.next);
        }
        return mergedHead;
    }
}
