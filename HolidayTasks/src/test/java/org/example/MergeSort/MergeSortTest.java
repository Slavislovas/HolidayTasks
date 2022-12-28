package org.example.MergeSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] values = {13, 5, 33, 86, 12, 12, 4};
        int[] expectedValues = {4, 5, 12, 12, 13, 33, 86};

        MergeSort.sort(values);
        assertArrayEquals(expectedValues, values);
    }
}