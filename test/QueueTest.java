import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void queue() {
        Queue<Character> q = new Queue();
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        assertEquals('a', q.dequeue());
        assertEquals('b', q.dequeue());
        assertEquals('c', q.dequeue());
    }

    @Test
    void isEmpty() {
        Queue<Character> q = new Queue();
        assertTrue(q.isEmpty());
        q.enqueue('a');
        assertFalse(q.isEmpty());
    }

    @Test
    void generic() {
        Queue<Double> q = new Queue();
        q.enqueue(3.1415);
        assertFalse(q.isEmpty());
    }

}
