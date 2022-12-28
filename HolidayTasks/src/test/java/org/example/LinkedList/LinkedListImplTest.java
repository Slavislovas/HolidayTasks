package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListImplTest {

    @Test
    public void add() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);
        assertEquals(1,linkedList.getAtIndex(0));
        assertEquals(5,linkedList.getAtIndex(1));
        assertEquals(10,linkedList.getAtIndex(2));
    }

    @Test
    public void addToIndex_addToStart() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        linkedList.addToIndex(0,15);
        assertEquals(15, linkedList.getAtIndex(0));
        assertEquals(1,linkedList.getAtIndex(1));
        assertEquals(5,linkedList.getAtIndex(2));
        assertEquals(10,linkedList.getAtIndex(3));
    }

    @Test
    public void addToIndex_addToMiddle() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        linkedList.addToIndex(1,15);
        assertEquals(1,linkedList.getAtIndex(0));
        assertEquals(15,linkedList.getAtIndex(1));
        assertEquals(5,linkedList.getAtIndex(2));
        assertEquals(10,linkedList.getAtIndex(3));
    }

    @Test
    public void addToIndex_addToLastIndex() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        linkedList.addToIndex(2,15);
        assertEquals(1,linkedList.getAtIndex(0));
        assertEquals(5,linkedList.getAtIndex(1));
        assertEquals(15,linkedList.getAtIndex(2));
        assertEquals(10,linkedList.getAtIndex(3));
    }


    @Test
    public void addToIndex_addToOutOfBounds() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.addToIndex(3, 10));
    }

    @Test
    public void getAtIndex_getStart() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        assertEquals(1, linkedList.getAtIndex(0));
    }

    @Test
    public void getAtIndex_getMiddle() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        assertEquals(5, linkedList.getAtIndex(1));
    }

    @Test
    public void getAtIndex_getLast() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        assertEquals(10, linkedList.getAtIndex(2));
    }

    @Test
    public void getAtIndex_getOutOfBounds() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getAtIndex(3));
    }

    @Test
    public void deleteAtIndex_deleteStart() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        linkedList.deleteAtIndex(0);
        assertEquals(5, linkedList.getAtIndex(0));
        assertEquals(10, linkedList.getAtIndex(1));
    }

    @Test
    public void deleteAtIndex_deleteMiddle() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        linkedList.deleteAtIndex(1);
        assertEquals(1, linkedList.getAtIndex(0));
        assertEquals(10, linkedList.getAtIndex(1));
    }

    @Test
    public void deleteAtIndex_deleteLast() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        linkedList.deleteAtIndex(2);
        assertEquals(1, linkedList.getAtIndex(0));
        assertEquals(5, linkedList.getAtIndex(1));
        assertEquals(2, linkedList.getCount());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getAtIndex(2));
    }

    @Test
    public void deleteAtIndex_deleteOutOfBounds() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(10);

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.deleteAtIndex(3));
    }
}