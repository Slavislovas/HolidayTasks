package org.example.BinaryTree;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BinaryTreeImplTest {

    @Test
    public void insert() {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        int[] array = {9,8,7,6,5,5,1,2,3};
        binaryTree.insert(array);
        assertArrayEquals(array, binaryTree.toArray());
    }

    @Test
    public void find_success() {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        int[] array = {9,8,7,6,5,5,1,2,3};
        binaryTree.insert(array);
        assertEquals(6, binaryTree.find(6));
    }

    @Test
    public void find_notFound_treeFull() {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        int[] array = {9,8,7,6,5,5,1,2,3};
        binaryTree.insert(array);
        assertThrows(NoSuchElementException.class, () -> binaryTree.find(96));
    }

    @Test
    public void find_notFound_treeEmpty() {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        assertThrows(NoSuchElementException.class, () -> binaryTree.find(96));
    }

    @Test
    public void delete_success() {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        int[] array = {9,8,7,6,5,5,1,2,3};
        int[] expected = {9,3,7,6,5,5,1,2};
        binaryTree.insert(array);
        assertEquals(true, binaryTree.delete(8));
        assertArrayEquals(expected, binaryTree.toArray());
    }

    @Test
    public void delete_elementNotFound() {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        int[] array = {9,8,7,6,5,5,1,2,3};
        binaryTree.insert(array);
        assertEquals(false, binaryTree.delete(84));
        assertArrayEquals(array, binaryTree.toArray());
    }

    @Test
    public void delete_treeEmpty() {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        int[] array = {};
        assertEquals(false, binaryTree.delete(8));
        assertArrayEquals(array, binaryTree.toArray());
    }
}