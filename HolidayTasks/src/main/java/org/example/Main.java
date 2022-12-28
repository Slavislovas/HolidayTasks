package org.example;

import org.example.LinkedList.LinkedListImpl;

public class Main {
    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.print();
        System.out.println();
        linkedList.addToIndex(2, 20);
        System.out.println();
        linkedList.print();
        System.out.println();
        System.out.println(linkedList.getAtIndex(3));
        System.out.println();
        linkedList.deleteAtIndex(2);
        linkedList.print();
        System.out.println();
        linkedList.deleteAtIndex(2);
        linkedList.print();
    }
}