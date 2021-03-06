public class BinarySearch {

    /**
     * Searches the integer key in a sorted array of integers.
     *
     * Binary search.
     *
     * @param key  the key
     * @param a  the array
     * @return the index of the first occurrence of key in a, or -1 if key is not found
     */
    public static int search(int key, int[] a) {
        return search(key, a, 0, a.length);
    }

    private static int search(int key, int[] a, int lo, int hi) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo)/2;
        if      (a[mid] > key) return search(key, a, lo, mid);
        else if (a[mid] < key) return search(key, a, mid + 1, hi);
        else                   return mid;
    }

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) { a[i] = i; }
        int[] k = new int[1000];
        for (int i = 0; i < k.length; ++i) { k[i] = StdRandom.uniform(n); }
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < k.length; ++i) { search(k[i], a); }
        return timer.elapsedTime();
    }

    public static void main(String[] unused) {
        double previous = timeTrial(256);
        for (int n = 512; true; n *= 2) {
            double current = timeTrial(n);
            double ratio = current/previous;
            StdOut.printf("%7d %4.2f\n", n ,ratio);
            previous = current;
        }
    }

}
