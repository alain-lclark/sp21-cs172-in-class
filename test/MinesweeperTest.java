import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MinesweeperTest {

    @Test
    void countNeighboringMines() {
    }

    @Test
    void hasWon() {
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
        assertEquals(expected, uncovered);
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

        assertEquals(expected, uncovered);
    }

        @Test
    void initMinefield() {
    }
}