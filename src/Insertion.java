public class Insertion {

    /**
     * Returns true if the values in [lo, hi) of the array a are sorted
     * @param a  an array of integers
     * @param lo  start of the range (inclusive)
     * @param hi  end of the range (exclusive)
     * @return true if the values in [lo, hi) of the array a are sorted
     */
    private static boolean isSorted(int[] a, int lo, int hi) {
        for (; lo < hi - 1; ++lo)
            if (a[lo] > a[lo + 1]) return false;
        return true;
    }

    /**
     * Sorts the array of numbers using the insertion sort algorithm
     * @param a  array to be sorted
     */
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            // pre-condition: a[0 .. i - 1] is sorted
            assert isSorted(a, 0, i);
            // insert a[i] in a[0 ...  i - 1] in the correct spot
            for (int j = i; j > 0; --j) {
                if (a[j - 1] > a[j]) {
                    // swap a[j - 1] and a[j]
                    int x = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = x;
                }
                else {
                    break;
                }
            }
            // post condition: a[0 ... i] is sorted
            assert isSorted(a, 0, i + 1);
        }
    }

    private static double runTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = StdRandom.uniform(2000000) - 1000000;
        Stopwatch timer = new Stopwatch();
        sort(a);
        return timer.elapsedTime();
    }

    public static void main(String[] unused) {
        int n = 512;
        double previous = runTrial(n / 2);
        StdOut.printf("        n ratio\n");
        for (; true; n *= 2) {
            double current = runTrial(n);
            double ratio = current / previous;
            StdOut.printf("%9d %4.2f\n", n, ratio);
            previous = current;
        }
    }

}
