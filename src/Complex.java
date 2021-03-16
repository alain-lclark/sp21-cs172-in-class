/**
 * Complex numbers are of the form x + iy where both x and y are real numbers.
 */
public class Complex {

    final private double re;
    final private double im;

    /**
     * Initializes the newly created Complex number with the given real
     * and imaginary arguments.
     * @param re the real part
     * @param im the imaginary part
     */
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * Initializes the newly created Complex number to 0.
     */
    public Complex() {
        re = 0;
        im = 0;
    }

    /**
     * Returns the real part of this Complex number.
     * @return the real part of this number
     */
    public double re() {
        return re;
    }

    /**
     * Returns the imaginary part of this Complex number.
     * @return the imaginary part of this number
     */
    public double im() {
        return im;
    }

    public String toString() {
        return re + " + " + im + "i";
    }

    /**
     * Adds Complex b to this Complex number
     * Complex addition: (x + iy) + (v + iw) = (x + v) + i(y + w)
     * @param b a complex number to add
     * @return the sum of this number and b
     */
    public Complex plus(Complex b) {
        double real = re + b.re;
        double imag = im + b.im;
        return new Complex(real, imag);
    }

    /**
     * Multiplies Complex b to this Complex number
     * Complex multiplication: (x + iy) * (v + iw) = (xv - yw) + i(yv + xw)
     * @param b a complex number to multiply
     * @return the sum of this number and b
     */
    public Complex times(Complex b) {
        double real = re * b.re - im * b.im;
        double imag = re * b.im + im * b.re;
        return new Complex(real, imag);
    }

    /**
     * Computes the magnitude of this Complex number.
     * @return the magnitude of this number
     */
    public double abs() {
        return Math.sqrt(re*re + im*im);
    }

}
