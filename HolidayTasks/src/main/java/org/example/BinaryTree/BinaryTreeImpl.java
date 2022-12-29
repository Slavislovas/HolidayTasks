package org.example.BinaryTree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinaryTreeImpl {
    private BinaryTreeNode root;
    private int count;
    public BinaryTreeImpl(){
        root = null;
        count = 0;
    }

    public void insert(int[] values){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        int index = 0;
        if (root == null){
            root = new BinaryTreeNode(values[index++]);
            count++;
        }
        queue.add(root);
        BinaryTreeNode current = new BinaryTreeNode();
        while (!queue.isEmpty()){
            current = queue.peek();
            queue.remove();

            if (current.getLeft() == null){
                current.setLeft(new BinaryTreeNode(values[index++]));
                count++;
                if(index == values.length){
                    break;
                }
                queue.add(current.getLeft());
            } else {
                queue.add(current.getLeft());
            }

            if (current.getRight() == null){
                current.setRight(new BinaryTreeNode(values[index++]));
                count++;
                if(index == values.length){
                    break;
                }
                queue.add(current.getRight());
            } else {
                queue.add(current.getRight());
            }
        }
    }

    public int find(int value){
        if (root == null){
            throw new NoSuchElementException();
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode current = queue.peek();
            queue.remove();

            if(current.getValue() == value){
                return value;
            }

            if(current.getLeft() != null){
                queue.add(current.getLeft());
            }

            if (current.getRight() != null){
                queue.add(current.getRight());
            }
        }
        throw new NoSuchElementException();
    }

    public boolean delete(int value){
        if (root == null){
            return false;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryTreeNode current = queue.peek();
            queue.remove();

            if (current.getValue() == value){
                BinaryTreeNode deepestNode = findAndDetachDeepestNode();
                current.setValue(deepestNode.getValue());
                count--;
                return true;
            }

            if (current.getLeft() != null){
                queue.add(current.getLeft());
            }

            if (current.getRight() != null){
                queue.add(current.getRight());
            }
        }
        return false;
    }

    private BinaryTreeNode findAndDetachDeepestNode() {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<BinaryTreeNode> parentQueue = new LinkedList<>();
        parentQueue.add(root);
        BinaryTreeNode parent = null;
        BinaryTreeNode last = null;
        int side = 0; // 0 means left, 1 means right, this is needed to determine
                      // which reference (left or right) to set to null of the parent node

        while(!queue.isEmpty()){
            last = queue.peek();
            queue.remove();
            parent = parentQueue.peek();
            parentQueue.remove();

            if(last.getLeft() != null){
                parentQueue.add(last);
                queue.add(last.getLeft());
                side = 0;
            }

            if(last.getRight() != null){
                parentQueue.add(last);
                queue.add(last.getRight());
                side = 1;
            }
        }
        if (side == 0){
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }

        return last;
    }

    public int[] toArray(){
        if (root == null){
            return new int[]{};
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        int[] array = new int[count];
        int index = 0;

        while(!queue.isEmpty()){
            BinaryTreeNode current = queue.peek();
            queue.remove();
            array[index++] = current.getValue();

            if (current.getLeft() != null){
                queue.add(current.getLeft());
            }

            if (current.getRight() != null){
                queue.add(current.getRight());
            }
        }

        return array;
    }
}
