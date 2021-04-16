public class LinkedList implements List {

    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void add(String item) {
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

    public String get(int index) {
        int i = 0;
        Node n = head;
        while (i < index) {
            n = n.next;
            ++i;
        }
        return n.item;
    }

    public void removeAt(int index) {

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

}
