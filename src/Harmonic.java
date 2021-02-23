public class Harmonic {

    /**
     * Returns the nth harmonic number
     * H1   = 1
     * Hn-1 = 1 + 1/2 + 1/3 + ... + 1/(n-1)
     * Hn   = 1 + 1/2 + 1/3 + ... + 1/(n-1) + 1/n
     * Hn   = Hn-1                          + 1/n
     * @param n  positive integer
     * @return the nth harmonic number
     */
    public static double harmonic(int n) {
        if (n == 1) return 1.0;
               else return harmonic(n - 1) + 1.0/n;
    }

}
