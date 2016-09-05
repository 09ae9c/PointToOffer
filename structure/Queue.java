package structure;

/**
 * Created by tc on 9/5/16.链表实现的队列
 */
public class Queue<Item> {


    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }


    private Node first;
    private Node last;
    private int N;

    public Queue() {
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node(item);

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item out = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return out;
    }
}
