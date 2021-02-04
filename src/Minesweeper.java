public class Minesweeper {

    public static void main(String[] unused) {
        StdOut.println("Welcome to Minesweeper");

        int SIZE = 10;
        int NUM_MINES = 10;

        boolean[][] minefield = new boolean[SIZE][SIZE];

        initMinefield(minefield, NUM_MINES);

        drawMinefield(minefield);

        while (true) {
            handleMouseClick(minefield);
            drawMinefield(minefield);
            if (hasWon()) {
                StdOut.println("You won!");
                break;
            }
        }
    }

    public static void handleMouseClick(boolean[][] minefield) {
    }

    public static int countNeighboringMines(boolean[][] minefield, int x, int y) {
        int count = 0;
        for (int x1 = x - 1; x1 < x + 1; ++x1) {
            for (int y1 = y - 1; y1 < y + 1; ++y1) {
                if (x1 >= 0 && x1 < minefield.length &&
                    y1 >= 0 && y1 < minefield.length &&
                    (x1 != x || y1 != y)) {
                    if (minefield[x1][y1]) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    public static boolean hasWon() {
        return false;
    }

    public static void uncover() {
    }

    public static void initMinefield(boolean[][] minefield, int numMines) {
        for (int i = 0; i < numMines; ++i) {
            int x = StdRandom.uniform(minefield.length);
            int y = StdRandom.uniform(minefield.length);
            if (minefield[x][y]) {
                --i;
            }
            else {
                minefield[x][y] = true;
            }
        }
    }

    public static void drawMinefield(boolean[][] minefield) {
        StdDraw.setScale(-0.5, minefield.length - 0.5);
        for (int i = 0; i < minefield.length; ++i) {
            StdDraw.square(i, 0, 0.5);
        }
    }

}
