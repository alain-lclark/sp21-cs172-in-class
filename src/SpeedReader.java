public class SpeedReader {

    public static void main(String[] unused) {
        In file = new In("speed.txt");
        while (!file.isEmpty()) {
            String s = file.readLine();
            StdOut.println(s);
        }
    }

}
