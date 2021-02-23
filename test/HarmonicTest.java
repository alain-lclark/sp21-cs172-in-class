import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HarmonicTest {

    @Test
    void harmonic() {
        assertEquals(1.0, Harmonic.harmonic(1));
        assertEquals(3.0/2.0, Harmonic.harmonic(2));
        assertEquals(11.0/6.0, Harmonic.harmonic(3));
    }

}
