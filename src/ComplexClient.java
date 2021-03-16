public class ComplexClient {

    static public void main(String[] unused) {
        Complex z0 = new Complex(1.0, 1.0);
        Complex z = z0;
        Complex z1 = new Complex(1.0, 1.0);

        StdOut.println(z0.plus(z0));
        StdOut.println("Real(z0) = " + z0.re());

        StdOut.println(z0 == z1);      // false, 2 different objects
        StdOut.println(z0 == z);       // true, both variables hold the same reference
        StdOut.println(z0.equals(z1)); // true, if Complex.equals() is implemented correctly
    }

}
