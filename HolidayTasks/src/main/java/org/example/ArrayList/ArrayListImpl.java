package org.example.ArrayList;

public class ArrayListImpl {
    int[] values;
    int count;

    public ArrayListImpl(){
        values = new int[16];
        count = 0;
    }

    public void add(int value){
        if(count + 1 > values.length){
            ensureCapacity();
        }
        values[count++] = value;
    }

    public void addToIndex(int index, int value){
        for(int i = index; i < count; i++){
            values[i + 1] = values[i];
        }
    }

    public int getCount(){
        return count;
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
