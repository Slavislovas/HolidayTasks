package org.example.BubbleSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void bubbleSort() {
        int[] values = {5, 1, 56, 100, 5, 74, 12, 66};
        BubbleSort.bubbleSort(values);
        assertEquals(100, values[0]);
        assertEquals(74, values[1]);
        assertEquals(66, values[2]);
        assertEquals(56, values[3]);
        assertEquals(12, values[4]);
        assertEquals(5, values[5]);
        assertEquals(5, values[6]);
        assertEquals(1, values[7]);
    }
}