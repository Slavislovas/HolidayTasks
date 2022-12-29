package org.example;

import org.example.BinaryTree.BinaryTreeImpl;
import org.example.LinkedList.LinkedListImpl;

public class Main {
    public static void main(String[] args) {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        binaryTree.insert(new int[]{5, 5, 20, 2, 3, 1, 30, 15, 16, 14, 0});
        binaryTree.insert(new int[]{7, 100});
        int temp = 0;
        //binaryTree.delete(5);
        //binaryTree.delete(5);
        int temp2 = 0;
        int[] array = binaryTree.toArray();
    }
}