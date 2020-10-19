package Sorting.Tests;

import Sorting.Insertion;
import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class TestInsertionSort {

    @Test
    public void test10Double() {
        final int TEST_SIZE = 10;

        Double[] arr = new Double[TEST_SIZE];

        for (int i = 0; i < TEST_SIZE; ++i) {
            arr[i] = Math.floor(StdRandom.uniform() * TEST_SIZE);
        }
        Insertion s = new Insertion();
        s.sort(arr);
        s.show(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void test100Double() {
        final int TEST_SIZE = 100;

        Double[] arr = new Double[TEST_SIZE];

        for (int i = 0; i < TEST_SIZE; ++i) {
            arr[i] = Math.floor(StdRandom.uniform() * TEST_SIZE);
        }
        Insertion s = new Insertion();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void testKDouble() {
        final int TEST_SIZE = 1000;

        Double[] arr = new Double[TEST_SIZE];

        for (int i = 0; i < TEST_SIZE; ++i) {
            arr[i] = Math.floor(StdRandom.uniform() * TEST_SIZE);
        }
        Insertion s = new Insertion();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void test10KDouble() {
        final int TEST_SIZE = 10000;

        Double[] arr = new Double[TEST_SIZE];

        for (int i = 0; i < TEST_SIZE; ++i) {
            arr[i] = Math.floor(StdRandom.uniform() * TEST_SIZE);
        }
        Insertion s = new Insertion();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void test10String() {
        final int TEST_SIZE = 10;

        String[] arr = TestSelectionSort.generateRandomWords(TEST_SIZE);

        Insertion s = new Insertion();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void test100String() {
        final int TEST_SIZE = 100;

        String[] arr = TestSelectionSort.generateRandomWords(TEST_SIZE);

        Insertion s = new Insertion();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void testKString() {
        final int TEST_SIZE = 1000;

        String[] arr = TestSelectionSort.generateRandomWords(TEST_SIZE);

        Insertion s = new Insertion();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }
}
