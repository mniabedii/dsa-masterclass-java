package com.github.mniabedii.sorts;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean swapped;

        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    swap(j, arr);
                    swapped = true;
                }
            }

            // If no two element were swapped by inner loop, break
            if (!swapped)
                break;
        }
    }

    private static void swap(int j, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }
}
