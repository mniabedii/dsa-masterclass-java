package com.github.mniabedii.sorts;

public class CombSort {

    public static void combSort(int arr[]) {
        int size = arr.length;

        // Initialize gap
        int gap = size;

        // Bubble Sort:
        boolean swapped = true;

        while (gap != 1 || swapped == true) {

            gap = getNextGap(gap);
            swapped = false;

            // Compare all elements with the current gap
            for (int i = 0; i < size - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, gap);

                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    private static int getNextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;

        return gap;
    }

    private static void swap(int[] arr, int i, int gap) {
        int temp = arr[i];
        arr[i] = arr[i + gap];
        arr[i + gap] = temp;
    }
}
