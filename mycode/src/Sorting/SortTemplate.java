package Sorting;

public interface SortTemplate {
    void sort(Comparable[] a);

    default boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /** Swaps the ith with the jth entry in the given array a. */
    default void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /** prints all elements of a on the same line. */
    default void show(Comparable[] a) {
        for (Comparable x : a) {
            System.out.print(x + " ");
        }
    }

    default boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i].compareTo(a[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
