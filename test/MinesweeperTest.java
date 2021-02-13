import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MinesweeperTest {

    @Test
    void countNeighboringMines() {
    }

    @Test
    void hasWon() {
        boolean[][] minefield = {
                {  true, false, false, false},
                { false, false, false, false},
                { false, false, false, false},
                { false, false, false, false}
        };
        boolean[][] uncovered = {
                {false, true, true, true},
                { true, true, true, true},
                { true, true, true, true},
                { true, true, true, true}
        };

        assertTrue(Minesweeper.hasWon(minefield, uncovered));
    }

    @Test
    void hasNotWonYet() {
        boolean[][] minefield = {
                {  true, false, false, false},
                { false, false, false, false},
                { false, false, false, false},
                { false, false, false, false}
        };
        boolean[][] uncovered = {
                {false, true, true, true},
                { true, true, true, true},
                { true, true, true, true},
                {false, true, true, true}
        };

        assertFalse(Minesweeper.hasWon(minefield, uncovered));
    }

    @Test
    void uncover1() {
        boolean[][] minefield = {
                {  true, false, false, false},
                { false, false, false, false},
                { false, false, false, false},
                { false, false, false, false}
        };
        boolean[][] uncovered = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        Minesweeper.uncover(minefield, uncovered, 1, 0);

        boolean[][] expected = {
                {false, false, false, false},
                { true, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };
        assertArrayEquals(expected, uncovered);
    }

    @Test
    void uncover0() {
        boolean[][] minefield = {
                { true, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };
        boolean[][] uncovered = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        Minesweeper.uncover(minefield, uncovered, 3, 0);

        boolean[][] expected = {
                {false, true, true, true},
                { true, true, true, true},
                { true, true, true, true},
                { true, true, true, true}
        };

        assertArrayEquals(expected, uncovered);
    }

    @Test
    void initMinefield() {
        boolean[][] minefield = new boolean[4][4];
        Minesweeper.initMinefield(minefield, 10);
        int count = 0;
        for (int x = 0; x < minefield.length; ++x) {
            for (int y = 0; y < minefield.length; ++y) {
                if (minefield[x][y]) ++count;
            }
        }
        assertEquals(10, count);
    }
}