package com.github.mniabedii.sorts;

public class RadixSort {

    public static void radixSort(int arr[]) {
        // find the maximum element to know the number of digits
        int maxElement = getMax(arr);

        /*
         * Do counting sort for every digit, Note that instead of passing
         * digit number, exp is passed which is 10^i where i is the current digit number
         */
        for (int exp = 1; maxElement / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int arr[], int exp) {
        int output[] = new int[arr.length];
        int i;
        int countArray[] = new int[10];

        // Store count of occurrences in countArray[]
        // arr[i] / exp) % 10: using this to calculate the digit
        for (i = 0; i < arr.length; i++)
            countArray[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            countArray[i] += countArray[i - 1];

        // Build the output array
        for (i = arr.length - 1; i >= 0; i--) {
            output[countArray[(arr[i] / exp) % 10] - 1] = arr[i];
            countArray[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
