public class Factorial {

    /**
     * Computes the factorial of a number
     * fac(1) = 1
     * fac(2) = 1*2
     * fac(3) = 1*2*3
     * ...
     * fac(n) = 1*2*3* ... (n-1)*n
     * fac(n) = fac(n-1)        *n
     * @param n  a positive integer
     * @return the factorial of n
     */
    static public int fac(int n) {
        if (n == 1) return 1;
        return fac(n-1) * n;
    }

}
