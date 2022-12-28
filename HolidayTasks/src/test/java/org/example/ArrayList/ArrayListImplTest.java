package org.example.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListImplTest {

    @Test
    public void add() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.getAtIndex(0));
        assertEquals(2, list.getAtIndex(1));
        assertEquals(3, list.getAtIndex(2));
        assertEquals(3, list.getCount());
    }

    @Test
    public void add_ensureCapacity() {
        ArrayListImpl list = new ArrayListImpl(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(1, list.getAtIndex(0));
        assertEquals(2, list.getAtIndex(1));
        assertEquals(3, list.getAtIndex(2));
        assertEquals(4, list.getAtIndex(3));
        assertEquals(4, list.getCount());
        assertEquals(6, list.getArrayLength());
    }

    @Test
    public void addToIndex_addToStart() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addToIndex(0, 15);

        assertEquals(15, list.getAtIndex(0));
        assertEquals(1, list.getAtIndex(1));
        assertEquals(2, list.getAtIndex(2));
        assertEquals(3, list.getAtIndex(3));
        assertEquals(4, list.getCount());
    }

    @Test
    public void addToIndex_addToMiddle() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addToIndex(1, 15);

        assertEquals(1, list.getAtIndex(0));
        assertEquals(15, list.getAtIndex(1));
        assertEquals(2, list.getAtIndex(2));
        assertEquals(3, list.getAtIndex(3));
        assertEquals(4, list.getCount());
    }

    @Test
    public void addToIndex_addToLast() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addToIndex(2, 15);

        assertEquals(1, list.getAtIndex(0));
        assertEquals(2, list.getAtIndex(1));
        assertEquals(15, list.getAtIndex(2));
        assertEquals(3, list.getAtIndex(3));
        assertEquals(4, list.getCount());
    }

    @Test
    public void addToIndex_ensureCapacity() {
        ArrayListImpl list = new ArrayListImpl(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.addToIndex(1, 15);

        assertEquals(1, list.getAtIndex(0));
        assertEquals(15, list.getAtIndex(1));
        assertEquals(2, list.getAtIndex(2));
        assertEquals(3, list.getAtIndex(3));
        assertEquals(4, list.getCount());
        assertEquals(6, list.getArrayLength());
    }

    @Test
    public void addToIndex_outOfBounds() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.addToIndex(3, 15));
    }

    @Test
    public void deleteAtIndex_deleteStart() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.deleteAtIndex(0);
        assertEquals(2, list.getAtIndex(0));
        assertEquals(3, list.getAtIndex(1));
        assertEquals(2, list.getCount());
    }

    @Test
    public void deleteAtIndex_deleteMiddle() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.deleteAtIndex(1);
        assertEquals(1, list.getAtIndex(0));
        assertEquals(3, list.getAtIndex(1));
        assertEquals(2, list.getCount());
    }

    @Test
    public void deleteAtIndex_deleteLast() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.deleteAtIndex(2);
        assertEquals(1, list.getAtIndex(0));
        assertEquals(2, list.getAtIndex(1));
        assertEquals(2, list.getCount());
    }

    @Test
    public void deleteAtIndex_outOfBounds() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.deleteAtIndex(3));
    }

    @Test
    public void getAtIndex() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);

        int value = list.getAtIndex(1);
        assertEquals(2, value);
    }

    @Test
    public void getAtIndex_outOfBounds() {
        ArrayListImpl list = new ArrayListImpl();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> list.getAtIndex(3));
    }
}