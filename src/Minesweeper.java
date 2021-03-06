public class Minesweeper {

    public static void main(String[] unused) {
        StdOut.println("Welcome to Minesweeper");

        int SIZE = 10;
        int NUM_MINES = 10;

        FieldLocation[][] minefield = new FieldLocation[SIZE][SIZE];
        for (int x = 0; x < minefield.length; ++x) {
            for (int y = 0; y < minefield.length; ++y) {
                minefield[x][y] = new FieldLocation();
            }
        }

        initMinefield(minefield, NUM_MINES);

        StdDraw.setScale(-0.5, minefield.length - 0.5);
        StdDraw.enableDoubleBuffering();

        drawMinefield(minefield);

        while (true) {
            handleMouseClick(minefield);
            drawMinefield(minefield);
            if (hasWon(minefield)) {
                StdOut.println("You won!");
                break;
            }
        }
    }

    public static void handleMouseClick(FieldLocation[][] minefield) {
        while (!StdDraw.isMousePressed()) {
            // do nothing
        }

        int x = (int)Math.round(StdDraw.mouseX());
        int y = (int)Math.round(StdDraw.mouseY());

        while (StdDraw.isMousePressed()) {
            // do nothing
        }

        uncover(minefield, x, y);

        if (minefield[x][y].mined) {
            StdOut.println("BOOM");
        }
    }

    public static int countNeighboringMines(FieldLocation[][] minefield, int x, int y) {
        int count = 0;
        for (int x1 = x - 1; x1 <= x + 1; ++x1) {
            for (int y1 = y - 1; y1 <= y + 1; ++y1) {
                if (x1 >= 0 && x1 < minefield.length &&
                    y1 >= 0 && y1 < minefield.length &&
                    (x1 != x || y1 != y)) {
                    if (minefield[x1][y1].mined) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    public static boolean hasWon(FieldLocation[][] minefield) {
        for (int x = 0; x < minefield.length; ++x) {
            for (int y = 0; y < minefield.length; ++y) {
                if (!minefield[x][y].mined && !minefield[x][y].uncovered) return false;
            }
        }
        return true;
    }

    public static void uncover(FieldLocation[][] minefield, int x, int y) {
        if (!minefield[x][y].uncovered) {
            minefield[x][y].uncovered = true;
            if (countNeighboringMines(minefield, x, y) == 0) {
                for (int x1 = x - 1; x1 <= x + 1; ++x1) {
                    for (int y1 = y - 1; y1 <= y + 1; ++y1) {
                        if (x1 >= 0 && x1 < minefield.length
                            && y1 >= 0 && y1 < minefield.length) {
                            uncover(minefield, x1, y1);
                        }
                    }
                }
            }
        }
    }

    public static void initMinefield(FieldLocation[][] minefield, int numMines) {
        for (int i = 0; i < numMines; ++i) {
            int x = StdRandom.uniform(minefield.length);
            int y = StdRandom.uniform(minefield.length);
            if (minefield[x][y].mined) {
                --i;
            }
            else {
                minefield[x][y].mined = true;
            }
        }
    }

    public static void drawMinefield(FieldLocation[][] minefield) {
        StdDraw.clear();
        for (int x = 0; x < minefield.length; ++x) {
            for (int y = 0; y < minefield.length; ++y) {
                if (!minefield[x][y].uncovered) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.5);
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                else if (minefield[x][y].mined) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledCircle(x,y, 0.3);
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                else {
                    int count = countNeighboringMines(minefield, x, y);
                    if (count != 0) StdDraw.text(x, y, "" + count);
                }
                StdDraw.square(x, y, 0.5);
            }
        }
        StdDraw.show();
    }

}
