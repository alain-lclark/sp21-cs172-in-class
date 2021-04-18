import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAddAndGet() {
        List l  = new LinkedList();
        l.add("a");
        l.add("b");
        l.add("c");
        assertEquals("a", l.get(0));
        assertEquals("b", l.get(1));
        assertEquals("c", l.get(2));
    }

    @Test
    void testLength() {
        List l  = new LinkedList();
        assertEquals(0, l.length());
        l.add("a");
        l.add("b");
        l.add("c");
        assertEquals(3, l.length());
    }

    @Test
    void testRemoveAt() {
        List l  = new LinkedList();
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

}
