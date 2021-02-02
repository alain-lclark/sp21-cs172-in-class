public class Minesweeper {

    public static void main(String[] unused) {
        StdOut.println("Welcome to Minesweeper");

        boolean[][] minefield = new boolean[10][10];

        drawMinefield(minefield);
    }

    public static int countNeighboringMines(boolean[][] minefield, int x, int y) {
        return 0;
    }

    public static boolean hasWon() {
        return false;
    }

    public static void uncover() {
    }

    public static void initMinefield(boolean[][] minefield) {

    }

    public static void drawMinefield(boolean[][] minefield) {
        StdDraw.setScale(-0.5, minefield.length - 0.5);
        for (int i = 0; i < minefield.length; ++i) {
            StdDraw.square(i, 0, 0.5);
        }
    }

}
