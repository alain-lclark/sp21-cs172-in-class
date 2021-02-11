public class Minesweeper {

    public static void main(String[] unused) {
        StdOut.println("Welcome to Minesweeper");

        int SIZE = 10;
        int NUM_MINES = 10;

        boolean[][] minefield = new boolean[SIZE][SIZE];
        boolean[][] uncovered = new boolean[SIZE][SIZE];

        initMinefield(minefield, NUM_MINES);

        drawMinefield(minefield);

        while (true) {
            handleMouseClick(minefield, uncovered);
            drawMinefield(minefield);
            if (hasWon()) {
                StdOut.println("You won!");
                break;
            }
        }
    }

    public static void handleMouseClick(boolean[][] minefield, boolean[][] uncovered) {
        while (!StdDraw.isMousePressed()) {
            // do nothing
        }

        int x = (int)Math.round(StdDraw.mouseX());
        int y = (int)Math.round(StdDraw.mouseY());

        while (StdDraw.isMousePressed()) {
            // do nothing
        }

        uncover(minefield, uncovered, x, y);

        if (minefield[x][y]) {
            StdOut.println("BOOM");
        }
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

    public static void uncover(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        uncovered[x][y] = true;
        if (countNeighboringMines(minefield, x, y) == 0) {
            percolate(minefield, uncovered);
        }
    }

    public static void percolate(boolean[][] minefield, boolean[][] uncovered) {
        while (true) {
            boolean equilibriumReached = true;
            for (int x = 0; x < minefield.length; ++x) {
                for (int y = 0; y < minefield.length; ++y) {
                    if (hasAMineFreeAndUncoveredNeighbor(minefield, uncovered, x, y)) {
                        if (!uncovered[x][y]) {
                            equilibriumReached = false;
                            uncovered[x][y] = true;
                        }
                    }
                }
            }
            if (equilibriumReached) return;
        }
    }

    public static boolean hasAMineFreeAndUncoveredNeighbor(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        for (int x1 = x - 1; x1 <= x + 1; ++x1) {
            for (int y1 = y - 1; y1 <= y + 1; ++y1) {
                if (x1 >= 0 && x1 < uncovered.length &&
                        y1 >= 0 && y1 < uncovered.length &&
                        (x1 != x || y1 != y) &&
                        uncovered[x1][y1] &&
                        countNeighboringMines(minefield, x1, y1) == 0) {
                    return true;
                }
            }
        }
        return false;
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
        StdDraw.clear();
        StdDraw.setScale(-0.5, minefield.length - 0.5);
        for (int x = 0; x < minefield.length; ++x) {
            for (int y = 0; y < minefield.length; ++y) {
                StdDraw.square(x, y, 0.5);
            }
        }
    }

}
