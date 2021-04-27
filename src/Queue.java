public class Queue<E> {

    private Node head;  // removal point (points to item longest in the queue)
    private Node tail;  // insertion point

    private class Node {
        E item;
        Node next; // points to a younger element
    }

    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Adds an item to the queue.
     * @param item  item to be added
     */
    public void enqueue(E item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty()) head = tail;
        else           oldTail.next = tail;
    }

    /**
     * Removes an item from the queue.
     * @return the removed item
     */
    public E dequeue() {
        assert head != null; // assumes a well-behaved client
        E item = head.item;
        head = head.next;
        if (isEmpty()) tail = null;
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
