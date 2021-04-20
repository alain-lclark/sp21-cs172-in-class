import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAddAndGet() {
        List l  = new LinkedList<String>();
        l.add("a");
        l.add("b");
        l.add("c");
        assertEquals("a", l.get(0));
        assertEquals("b", l.get(1));
        assertEquals("c", l.get(2));
    }

    @Test
    void testAddAndGetWithInt() {
        List l  = new LinkedList<Integer>();
        int i = 1;
        l.add(i);
        l.add(2);
        l.add(3);
        assertEquals(1, l.get(0));
        assertEquals(2, l.get(1));
        assertEquals(3, l.get(2));
    }

    @Test
    void testLength() {
        List l  = new LinkedList<String>();
        assertEquals(0, l.length());
        l.add("a");
        l.add("b");
        l.add("c");
        assertEquals(3, l.length());
    }

    @Test
    void testRemoveAt() {
        List l  = new LinkedList<String>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.removeAt(1);
        assertEquals(2, l.length());
        assertEquals("a", l.get(0));
        assertEquals("c", l.get(1));
        l.removeAt(0);
        assertEquals(1, l.length());
        assertEquals("c", l.get(0));
    }

    @Test
    void testIterator() {
        List<Integer> container = new LinkedList<Integer>();
        container.add(1);
        container.add(5);
        container.add(-3);
        int sum = 0;
        for (Integer n : container) {
            sum += n;
        }
        assertEquals(3, sum);
    }

}
