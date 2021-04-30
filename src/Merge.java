public class Merge {

    /**
     * Returns true if the values in the range [lo, hi) of the array a are sorted.
     * @param a  an array of values
     * @param lo  start of the range inclusive
     * @param hi  end of the range exclusive
     * @return true if the values in the range [lo, hi) of the array a are sorted
     */
    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (; lo < hi - 1; ++lo)
            if (a[lo].compareTo(a[lo + 1]) > 0) return false;
        return true;

    }

    /**
     * Sorts the array of numbers in the range [lo ... hi).
     * @param a  the array to be sorted
     * @param aux  temporary storage
     * @param lo  low bound (inclusive)
     * @param hi  high bound (exclusive)
     */
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi - lo <= 1) return; // base case
        // Compute the mid-point
        int mid = lo + (hi - lo)/2;
        // Sort the two halves
        sort(a, aux, lo, mid);
        assert isSorted(aux, lo, mid);
        sort(a, aux, mid, hi);
        assert isSorted(aux, mid, hi);
        // Merge
        int l = lo;
        int r = mid;
        for (int k = lo; k < hi; ++k) {
            if      (l == mid)                 aux[k] = a[r++];
            else if (r == hi)                  aux[k] = a[l++];
            else if (a[r].compareTo(a[l]) < 0) aux[k] = a[r++];
            else                               aux[k] = a[l++];
        }
        // Copy back
        for (int k = lo; k < hi; ++k)
            a[k] = aux[k];
        assert isSorted(a, lo, hi);
    }

    /**
     * Sort the array of number using the insertion sort algorithm.
     * @param a  the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length);
    }

    private static double runTrial(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; ++i)
            a[i] = StdRandom.uniform(2000000) - 1000000;
        Stopwatch timer = new Stopwatch();
        sort(a);
        return timer.elapsedTime();
    }

    public static void main(String[] unused) {
        int n = 512;
        double previous = runTrial(n/2);
        StdOut.printf("        n ratio\n");
        for (; true; n *= 2) {
            double current = runTrial(n);
            double ratio = current / previous;
            StdOut.printf("%9d %4.2f\n", n, ratio);
            previous = current;
        }
    }

}
