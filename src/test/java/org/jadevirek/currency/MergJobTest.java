package org.jadevirek.currency;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergJobTest {

    @Test
    public void positiveTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        new MergeSortFJP().runMergeSort(actual);
        new MergeSortFJP().runMergeSort(expected);
        assertArrayEquals(expected, actual);
    }
}
