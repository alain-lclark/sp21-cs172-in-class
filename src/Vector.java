/**
 * A vector implementation based on the API for spatial vectors
 * described in Section 3.3 of the Textbook.
 *
 * It is a more general implementation of Vector than the requested in
 * the Defining Object assignment.
 */
public class Vector {

    private final double[] v;

    /**
     * Create a vector based on the given array of doubles.
     * @param a an array of doubles
     */
    public Vector(double[] a) {
        // Defensive copy.
        double[] v = new double[a.length];
        for (int i = 0; i < a.length; ++i)
            v[i] = a[i];
        this.v = v;
    }

    /**
     * Sums this vector with that.
     * @param that a vector
     * @return the sum of this and that vector
     */
    public Vector plus(Vector that) {
        double[] result = new double[v.length];
        for (int i = 0; i < v.length; ++i)
            result[i] = v[i] + that.v[i];
        return new Vector(result);
    }

    /**
     * Scales this vector by the given factor.
     * @param factor a factor
     * @return factor * this vector
     */
    public Vector scale(double factor) {
        // TBD
        return null;
    }

    /**
     * Returns the ith Cartesian coordinate of this vector.
     * @param i the desired coordinate
     * @return the ith Cartesian coordinate of this vector
     */
    public double cartesian(int i) {
        return v[i];
    }

    /**
     * Gives a string representation of this vector.
     * @return a string representation of this vector.
     */
    public String toString() {
        String s = "[";
        for (int i = 0; i < v.length - 1; ++i)
            s += v[i] + ", ";
        s += v[v.length- 1] + "]";
        return s;
    }

    /**
     * Compares this vector to the given object.
     * @param o an object
     * @return true if the object is a Vector and has the same content as this Vector
     */
    // Was automatically generated by IntelliJ when prompted.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return java.util.Arrays.equals(v, vector.v);
    }

    public static void main(String[] unused) {
        double[] a = {1.0, 1.0, 1.0};
        Vector va = new Vector(a);
        double[] b = {2.0, 0.0, -1.0};
        Vector vb = new Vector(b);
        System.out.println(va.plus(vb));
        System.out.println(vb);
        b[0] = 17.0;
        System.out.println(vb);
    }
}
