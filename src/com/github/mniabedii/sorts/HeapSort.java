package com.github.mniabedii.sorts;

import com.github.mniabedii.heap.*;

public class HeapSort {

    // Already implemented in heap class
    public static void heapSort(int[] arr) {
        Heap heap = new Heap(arr.length);
        heap.heapSort(arr);
    }
}
