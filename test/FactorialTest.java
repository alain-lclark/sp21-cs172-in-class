import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @org.junit.jupiter.api.Test
    void fac() {
        assertEquals(1, Factorial.fac(1));
        assertEquals(2, Factorial.fac(2));
        assertEquals(120, Factorial.fac(5));
    }

}
