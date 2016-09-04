package structure;

/**
 * Created by tc on 9/4/16. 含有 min 函数的栈结构
 * 详见 Q021
 */
public class MinStack {

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node top;
    private Node assistTop;//辅助栈
    private int size;

    public MinStack() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }


    public int pop() throws Exception {
        if (isEmpty() || assistTop == null) {
            throw new Exception("stack is empty");
        }
        assistTop = assistTop.next;
        int result = top.value;
        top = top.next;
        size--;
        return result;
    }

    public void push(int value) {
        int minValue = value;
        if (assistTop != null && value >= assistTop.value) {
            minValue = assistTop.value;
        }

        assistTop = new Node(minValue, assistTop);

        top = new Node(value, top);
        size++;
    }

    public int min() {
        return assistTop.value;
    }
}
