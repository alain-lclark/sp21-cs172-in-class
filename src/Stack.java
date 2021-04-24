public class Stack<E> {

    private Node top;

    private class Node {
        E item;
        Node next;
    }

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E item) {
        Node n = new Node();
        n.item = item;
        n.next = top;
        top = n;
    }

    public E pop() {
        E item = top.item;
        top = top.next;
        return item;
    }

}
