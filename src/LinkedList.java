import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private class Node {
        E item;
        Node next;

        public Node(E item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void add(E item) {
        Node n = new Node(item);
        if (head == null) {
            head = n;
        }
        else {
            assert head != null;
            Node i = head;
            while (i.next != null) {
                i = i.next;
            }
            assert i != null;
            i.next = n;
        }
    }

    public E get(int index) {
        int i = 0;
        Node n = head;
        while (i < index) {
            n = n.next;
            ++i;
        }
        return n.item;
    }

    public void removeAt(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        assert index > 0;
        int i = 0;
        Node n = head;
        Node p = null;
        while (i < index) {
            p = n;
            n = n.next;
            ++i;
        }
        assert p != null;
        p.next = n.next;
    }

    public int length() {
        int length = 0;
        Node n = head;
        while (n != null) {
            n = n.next;
            ++length;
        }
        return length;
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
