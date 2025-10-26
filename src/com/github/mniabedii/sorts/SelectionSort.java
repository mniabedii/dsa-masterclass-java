package com.github.mniabedii.sorts;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {

            // Assume the current position holds the minimum element
            int minIndex = i;

            // Iterate through the unsorted portion to find the actual minimum
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    // Update minIndex
                    minIndex = j;
                }
            }

            // Move minimum element to its correct position
            swap(i, minIndex, arr);
        }
    }

    private static void swap(int i, int minIndex, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
