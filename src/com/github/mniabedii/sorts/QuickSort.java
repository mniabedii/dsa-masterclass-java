package com.github.mniabedii.sorts;

public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi; // the partition return index of pivot
            pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            quickSort(arr, low, pi - 1);

            // Recursion calls for greater or equals elements
            quickSort(arr, pi + 1, high);
        }
    }

    // Lomuto partition scheme
    private static int partition(int[] arr, int low, int high) {

        // Choose the last element as the pivot
        int pivot = arr[high];

        /*
         * Index of smaller elements
         * which indicates the right position of the pivot found so far
         */
        int i = low - 1;

        /*
         * Traverse arr[low..high] and move all smaller elements to the left side.
         * Elements from low to i are smaller after every iteration.
         */
        for (int j = low; j < high; j++) {
            // if the current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++; // Increment the index of the smaller element
                // Swap arr[i] & arr[j]
                swap(arr, i, j);
            }
        }

        // Swap arr[i+1] and the pivot (arr[high])
        swap(arr, i + 1, high);

        return i + 1; // Return the partition index
    }

    // Utility Function:
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
