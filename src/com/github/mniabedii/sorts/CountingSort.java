package com.github.mniabedii.sorts;

public class CountingSort {

    public static void countingSort(int[] arr) {
        int sizeOfInput = arr.length;
        int sizeOfCountArr = 0;

        // calculate the size of count array
        for (int element : arr) {
            sizeOfCountArr = Math.max(sizeOfCountArr, element);
        }

        // define count array
        int[] countArray = new int[sizeOfCountArr + 1];

        // initialize count array based on input array
        for (int element : arr) {
            countArray[element]++;
        }

        // convert to cumulative count array
        for (int i = 1; i <= sizeOfCountArr; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] outputArray = new int[sizeOfInput];

        /*
         * Iterate starting from the end of the input array
         * & loading the output array
         */
        for (int i = sizeOfInput - 1; i >= 0; i--) {
            outputArray[countArray[arr[i]] - 1] = arr[i];
            countArray[arr[i]]--;
        }

        // Assign the output array to the input array
        for (int i = 0; i < sizeOfInput; i++) {
            arr[i] = outputArray[i];
        }
    }
}
