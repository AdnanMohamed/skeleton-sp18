package Sorting;

public class Insertion implements SortTemplate{
    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (a[j-1].compareTo(a[j]) < 0) {
                    break;
                }
                swap(a, j-1, j);
            }
        }
    }
}
