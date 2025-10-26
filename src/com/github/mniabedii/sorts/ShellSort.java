package com.github.mniabedii.sorts;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int size = arr.length;

        // Start with a large gap, then reduce the gap
        for (int gap = size / 2; gap > 0; gap /= 2) {

            // Perform a gapped insertion sort for this gap size.
            for (int i = gap; i < size; i++) {
                int temp = arr[i];
                int j = i - gap;

                // Shift earlier gap-sorted elements up until the correct location for arr[i] is
                // found
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }

                // Put temp (the original arr[i]) in its correct location
                arr[j + gap] = temp;
            }
        }
    }
}