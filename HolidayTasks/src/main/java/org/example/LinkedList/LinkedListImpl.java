package org.example.LinkedList;

public class LinkedListImpl {
    private Node head;
    private Node tail;
    private int count;

    public LinkedListImpl(){
        head = new Node();
        tail = null;
        head.setNext(tail);
        count = 0;
    }
    // Best case scenario, when the linked list is empty, the complexity is O(1)
    // Worst case scenario, when the linked list is not empty, the complexity is O(n)
    public void add(int value){
        Node current = head;
        if (count == 0){
            head = current;
            head.setNext(tail);
            head.setValue(value);
            count++;
        } else{
            while (current.getNext() != null){
                current = current.getNext();
            }
            Node node = new Node();
            node.setValue(value);
            current.setNext(node);
            node.setNext(tail);
            count++;
        }
    }
    // Best case scenario, when the index is 0, the complexity is O(1)
    // Worst case scenario, when the index is equals to the last index in the list, the complexity is O(n)
    public void addToIndex(int index, int value){
        if(index > count - 1){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            Node node = new Node();
            node.setValue(value);
            node.setNext(head);
            head = node;
            count++;
        } else{
            int currentIndex = 0;
            Node current = head;
            Node previous = current;
            while(currentIndex != index){
                previous = current;
                current = current.getNext();
                currentIndex++;
            }
            Node insertNode = new Node();
            insertNode.setValue(value);
            previous.setNext(insertNode);
            insertNode.setNext(current);
            count++;
        }
    }

    // Best case scenario, when the index is 0, the complexity is O(1)
    // Worst case scenario, when the index is equals to the last index in the list, the complexity is O(n)
    public int getAtIndex(int index){
        if(index > count - 1){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            return head.getValue();
        }

        int currentIndex = 0;
        Node current = head;

        while(currentIndex != index){
            current = current.getNext();
            currentIndex++;
        }
        return current.getValue();
    }

    // Best case scenario, when the index is equals to 0, the complexity is O(1)
    // Worst case scenario, when the index is equals to the last index in the list, the complexity is O(n)
    public void deleteAtIndex(int index){
        if(index > count - 1){
            throw new IndexOutOfBoundsException();
        }

        if(count == 0){
            System.out.println("Linked list is empty");
            return;
        }
        if(index == 0){
            head = head.getNext();
            count--;
        } else{
            int currentIndex = 0;
            Node currentNode = head;
            Node previousNode = new Node();
            while(currentIndex != index){
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            previousNode.setNext(currentNode.getNext());
            currentNode.setNext(null);
            count--;
        }
    }

    public int getCount(){
        return count;
    }


    public void print() {
        Node current = head;
        while(current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}
