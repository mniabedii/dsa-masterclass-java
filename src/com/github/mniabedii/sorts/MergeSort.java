package com.github.mniabedii.sorts;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        // Base case: if the array has one or no elements, it's already sorted.
        if (arr.length < 2) {
            return;
        }

        int midSize = arr.length / 2;

        // Divide the array into two halves
        int[] left = new int[midSize];
        int[] right = new int[arr.length - midSize];

        // Copy the elements into two halves
        for (int i = 0; i < midSize; i++) {
            left[i] = arr[i];
        }

        for (int i = midSize; i < arr.length; i++) {
            right[i - midSize] = arr[i];
        }

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right into arr in sorted order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements from left array, if any
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from right array, if any
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}