package structure;

/**
 * Created by tc on 2016/8/22. 栈--链表方式
 */
public class Stack<T> {

    private class Node {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int length() {
        return size;
    }

    public void push(T item) {
        top = new Node(item, top);
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }

        Node node = top;
        top = node.next;
        size--;
        return node.item;
    }

}
