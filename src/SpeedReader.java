public class SpeedReader {

    public static void main(String[] unused) {
        In file = new In("speed.txt");
        while (!file.isEmpty()) {
            String s = file.readLine();
            for (int i = 0; i < s.length(); i++) {
                String w = "";
                while (i < s.length() && s.charAt(i) != ' ') {
                    w = w + s.charAt(i);
                    ++i;
                }
                StdDraw.clear();
                StdDraw.text(0.5, 0.5, w);
                StdDraw.pause(500);
            }
        }
    }

}
