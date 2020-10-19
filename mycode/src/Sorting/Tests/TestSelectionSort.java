package Sorting.Tests;

import Sorting.Selection;
import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TestSelectionSort {
    public static String[] generateRandomWords(int numOfWords) {
        String[] randomStrings = new String[numOfWords];
        Random rand = new Random();

        for (int i = 0; i < numOfWords; ++i) {
            char[] word = new char[rand.nextInt(8) + 3];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char)('a' + rand.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    @Test
    public void test10Double() {
        final int TEST_SIZE = 10;

        Double[] arr = new Double[TEST_SIZE];

        for (int i = 0; i < TEST_SIZE; ++i) {
            arr[i] = Math.floor(StdRandom.uniform() * TEST_SIZE);
        }
        Selection s = new Selection();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void test100Double() {
        final int TEST_SIZE = 100;

        Double[] arr = new Double[TEST_SIZE];

        for (int i = 0; i < TEST_SIZE; ++i) {
            arr[i] = Math.floor(StdRandom.uniform() * TEST_SIZE);
        }
        Selection s = new Selection();
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
        Selection s = new Selection();
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
        Selection s = new Selection();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void test10String() {
        final int TEST_SIZE = 10;

        String[] arr = TestSelectionSort.generateRandomWords(TEST_SIZE);

        Selection s = new Selection();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void test100String() {
        final int TEST_SIZE = 100;

        String[] arr = TestSelectionSort.generateRandomWords(TEST_SIZE);

        Selection s = new Selection();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }

    @Test
    public void testKString() {
        final int TEST_SIZE = 1000;

        String[] arr = TestSelectionSort.generateRandomWords(TEST_SIZE);

        Selection s = new Selection();
        s.sort(arr);
        assertTrue(s.isSorted(arr));
    }
}
