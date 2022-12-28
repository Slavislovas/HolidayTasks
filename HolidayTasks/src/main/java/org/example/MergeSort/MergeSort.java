package org.example.MergeSort;

public class MergeSort {
    private static void merge(int[] values, int[] leftHalf, int[] rightHalf, int left, int right){
        int i = 0;
        int j = 0;
        int k = 0;
        // add the elements from the left and right halves to the input array
        while(i < left && j < right){
            if(leftHalf[i] <= rightHalf[j]){
                values[k++] = leftHalf[i++];
            } else {
                values[k++] = rightHalf[j++];
            }
        }
        // once one half is copied, copy the rest of the other half elements
        while (i < left){
            values[k++] = leftHalf[i++];
        }

        while (j < right){
            values[k++] = rightHalf[j++];
        }
    }
    // In all cases the complexity is O(n*logn), O(n) is the time taken to merge the array,
    // O(Logn) is the time taken to divide the input array
    public static void sort(int[] values){
        if(values.length  < 2){
            return;
        }
        int middle = values.length / 2;
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int [values.length - middle];

        // copy left half of the input array
        for(int i = 0; i < middle; i++){
            leftHalf[i] = values[i];
        }

        // copy right half of the input array
        for(int i = middle; i < values.length; i++){
            rightHalf[i - middle] = values[i];
        }

        // keep dividing the halves
        sort(leftHalf);
        sort(rightHalf);

        merge(values, leftHalf, rightHalf, middle, values.length - middle);
    }
}
