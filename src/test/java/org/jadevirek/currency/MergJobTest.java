package org.jadevirek.currency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;

public class MergJobTest {

    @Test
    public void positiveTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        new MergJob().runMergeSort(actual);
        new MergJob().runMergeSort(expected);
        assertArrayEquals(expected, actual);
    }
}
