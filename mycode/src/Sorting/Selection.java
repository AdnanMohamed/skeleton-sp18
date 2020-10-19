package Sorting;

public class Selection implements SortTemplate{
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; ++i) {
            int minIndex = smallest(a, i);
            swap(a, minIndex, i);
        }
    }

    /** Returns the index of the smallest element in a
     *  starting at start index.
     *
     * @param a - the array
     * @param start - the index to start searching from.
     */
    private int smallest(Comparable[] a, int start) {
        int minIndex = start;
        for (int i = start + 1; i < a.length; ++i) {
            if (less(a[i], a[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
