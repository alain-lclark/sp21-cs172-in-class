public class ComplexClient {

    static public void main(String[] unused) {
        Complex z0 = new Complex(1.0, 1.0);
        Complex z = z0;
        Complex z1 = new Complex();

        StdOut.println(z0.plus(z0));
        StdOut.println("Real(z0) = " + z0.re());
    }

}
