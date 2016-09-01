package chapter3;


/**
 * Created by tc on 9/1/16. 链表中倒数第 K 个节点
 * 输入一个链表,输出该链表中倒数第 K 个节点,从 1 开始计数,即链表的尾节点是倒数第 1 个节点
 * 例如一个链表: 1,2,3,4,5,6 倒数第 3 个节点是值为 4 的节点
 */
public class Q015 {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
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

        Node find1 = findKthToTail(head,3);
        if (find1!=null){
            System.out.println(find1.value);
        }

        Node find2 = findKthToTail(head,1);
        if (find2!=null){
            System.out.println(find2.value);
        }

        Node find3 = findKthToTail(head,6);
        if (find3!=null){
            System.out.println(find3.value);
        }

        Node find4 = findKthToTail(head,9);
        if (find4!=null){
            System.out.println(find4.value);
        }else {
            System.out.println("find4 error:index out of array");
        }
    }


    /**
     * 通过两个指针,实现一次遍历就找到倒数第 k 个节点
     *
     * 两个指针之间相差 k 个节点,这样在 ahead 指针走到链表尾部时,behind 指针离链表尾部 k 个节点,所以此时 behind 指向的节点就是要找的
     */
    private static Node findKthToTail(Node head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        Node ahead = head;
        Node behind = head;

        for (int i = 0; i < k-1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
            } else {//如果链表长度小于 K,则直接返回
                return null;
            }
        }

        while (ahead.next != null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        return behind;
    }
}
