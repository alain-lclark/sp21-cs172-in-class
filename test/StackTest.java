import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void isEmpty() {
        Stack<Integer> s = new Stack();
        assertTrue(s.isEmpty());
    }

    @Test
    void push() {
        Stack<Integer> s = new Stack();
        assertTrue(s.isEmpty());
        s.push(42);
        assertFalse(s.isEmpty());
    }

    @Test
    void pop() {
        Stack<Integer> s = new Stack();
        s.push(42); // 42 is on top
        s.push(-3); // -3 is on top
        s.push(11); // 11 is on top
        assertEquals(11, s.pop());
        assertEquals(-3, s.pop());
        assertEquals(42, s.pop());
    }

}
