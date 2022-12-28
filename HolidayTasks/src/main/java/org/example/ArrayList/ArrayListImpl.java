package org.example.ArrayList;

public class ArrayListImpl {
    int[] values;
    int count;

    public ArrayListImpl(){
        values = new int[16];
        count = 0;
    }

    public ArrayListImpl(int size){
        values = new int[size];
        count = 0;
    }
    // Complexity is always O(n) even when ensureCapacity is called since there are no nested loops
    public void add(int value){
        if(count + 1 > values.length){
            ensureCapacity();
        }
        values[count++] = value;
    }

    // Best case scenario, when the index is greater than the last index in the list since an exception
    // is only thrown or when the index is equal to the last index in the list since only 1 element
    // needs to be rearranged, complexity is O(1)
    // Worst case scenario, when the index is equals to 0 since all elements need to be rearranged
    // complexity is O(n)
    // ensureCapacity does not affect performance since there are no nested loops
    public void addToIndex(int index, int value){
        if(index > count - 1){
            throw new IndexOutOfBoundsException();
        }

        if(count + 1> values.length){
            ensureCapacity();
        }

        for(int i = count; i > index; i--){
            values[i] = values[i - 1];
        }
        values[index] = value;
        count++;
    }

    // Best case scenario, when the index is greater than the last index in the list since an exception
    // is only thrown or when the index is equal to the last index in the list since only 1 element
    // needs to be rearranged, complexity is O(1)
    // Worst case scenario, when the index is equals to 0 since all elements need to be rearranged
    // complexity is O(n)
    public void deleteAtIndex(int index){
        if(index > count - 1){
            throw new IndexOutOfBoundsException();
        }

        for(int i = index; i < count - 1; i++){
            values[i] = values[i + 1];
        }
        values[count - 1] = 0;
        count--;
    }
    // Complexity is always O(1)
    public int getAtIndex(int index){
        if(index > count - 1){
            throw new IndexOutOfBoundsException();
        }

        return values[index];
    }

    public int getCount(){
        return count;
    }

    public int getArrayLength(){
        return values.length;
    }

    public void print(){
        for (int value: values) {
            System.out.println(value);
        }
    }

    private void ensureCapacity(){
        int[] newArray = new int[values.length * 2];
        int index = 0;
        for (int value: values) {
            newArray[index++] = value;
        }
        values = newArray;
    }
}
