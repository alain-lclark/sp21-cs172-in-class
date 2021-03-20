public class Integrate {

    public static double integrate(Function f, double a, double b, int n) {
        double delta = (b - a)/n;
        double sum = 0.0;
        for (int i = 0; i < n; ++i) {
            sum += delta * f.evaluate(a + delta * i);
        }
        return sum;
    }

    public static void main(String[] unused) {
        StdOut.println(integrate(new Linear(), 0,  1, 10000));
        StdOut.println(integrate(new Quadratic(), 0, 1, 10000));
        StdOut.println(integrate(x -> x + 2, 0, 1, 10000));
    }
}
