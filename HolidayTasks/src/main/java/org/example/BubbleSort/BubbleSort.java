package org.example.BubbleSort;

public class BubbleSort {
    // In any case, the complexity is always O(n^2) since it doesn't matter if the array is already sorted
    // or not, the two for loops will always check all the elements in the array
    public static void bubbleSort(int[] values){
        int n = values.length;
        int temp = 0;
        for (int i = 0; i < n; i++){
            for (int j = 1; j < (n - i); j++){
                if(values[j - 1] < values[j]){
                    temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
                }
            }
        }
    }
}
