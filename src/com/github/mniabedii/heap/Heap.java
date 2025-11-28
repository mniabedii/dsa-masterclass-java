package com.github.mniabedii.heap;

import java.util.Arrays;

public class Heap {
    public enum HeapType {
        MIN_HEAP,
        MAX_HEAP
    }

    private int[] heap;
    private int size;
    private int capacity;
    private final HeapType type;

    public Heap(int capacity, HeapType type) {
        this.capacity = capacity;
        this.size = 0;
        this.type = type;
        this.heap = new int[capacity];
    }

    // Default: min-heap priority queue
    public Heap(int capacity) {
        this(capacity, HeapType.MIN_HEAP);
    }

    // Util Methods
    private int parent(int index) {
        return (index - 1) / 2; // 0-based version of ⌊i/2⌋
    }

    private int leftChild(int index) {
        return 2 * index + 1; // 0-based version of 2i
    }

    private int rightChild(int index) {
        return 2 * index + 2; // 0-based version of 2i + 1
    }

    // For a min-heap: compare(a, b) is true if a < b
    // For a max-heap: compare(a, b) is true if a > b
    private boolean compare(int a, int b) {
        if (type == HeapType.MIN_HEAP) {
            return a < b;
        } else {
            return a > b;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Heapify-Up (Percolate Up) O(lg(n))

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = parent(index);

            // If heap[index] should come before heap[parentIndex], swap
            if (compare(heap[index], heap[parentIndex])) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Heapify-Down (Percolate Down) O(lg(n))

    private void heapifyDown(int index) {
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);
            int best = index;

            // Choose child that maintains the heap-order property
            if (left < size && compare(heap[left], heap[best])) {
                best = left;
            }
            if (right < size && compare(heap[right], heap[best])) {
                best = right;
            }

            // If the best is still the current index, we are done
            if (best == index) {
                break;
            }

            swap(index, best);
            index = best;
        }
    }

    // Insertion O(lg(n))

    public void insert(int value) {
        heap[size] = value;
        size++;

        // Heapify up from the last index
        heapifyUp(size - 1);
    }

    // Peek (Find-Min / Find-Max) O(1)

    public int peek() throws Exception {
        if (size == 0) {
            throw new Exception("Underflow: heap is empty");
        }
        return heap[0];
    }

    // Extract-Min / Extract-Max O(lg(n))

    private int extractRoot() throws Exception {
        if (size == 0) {
            throw new Exception("Underflow: heap is empty");
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);
        return root;
    }

    // Build-Heap (Floyd's Algorithm)

    // Build heap from an arbitrary array (O(n))
    public void buildHeap(int[] arr) {
        this.size = arr.length;
        this.capacity = Math.max(arr.length, this.capacity);
        this.heap = Arrays.copyOf(arr, capacity);

        // Start from the lowest non-leaf node and heapify down to the root
        for (int i = parent(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Heap Sort (In-place, O(n log n))

    // NOTE: This uses a max-heap to get ascending order.
    public static void heapSort(int[] arr) {

        Heap maxHeap = new Heap(arr.length, HeapType.MAX_HEAP);
        maxHeap.buildHeap(arr);

        int n = maxHeap.size;
        // Repeatedly move the largest element to the end
        for (int i = n - 1; i >= 0; i--) {
            // Root is the current max
            int temp = maxHeap.heap[0];
            maxHeap.heap[0] = maxHeap.heap[maxHeap.size - 1];
            maxHeap.heap[maxHeap.size - 1] = temp;

            arr[i] = maxHeap.heap[maxHeap.size - 1]; // place max in sorted position
            maxHeap.size--;
            maxHeap.heapifyDown(0);
        }
    }

    // Priority Queue Operations
    /**
     * Decrease the key at index i to newKey (for MIN_HEAP).
     * This increases its priority (lower key = higher priority).
     */
    public void decreaseKey(int index, int newKey) {
        heap[index] = newKey;
        heapifyUp(index);
    }

    /**
     * Increase the key at index i to newKey (for MAX_HEAP).
     * This increases its priority (higher key = higher priority).
     */
    public void increaseKey(int index, int newKey) {

        heap[index] = newKey;
        heapifyUp(index);
    }

    /**
     * Delete the element at index i.
     * Runs in O(log n) by moving it to root position and extracting.
     */
    public void delete(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (type == HeapType.MIN_HEAP) {
            // For min-heap: decrease key to -inf, then extractMin
            decreaseKey(index, Integer.MIN_VALUE);
            extractRoot();
        } else {
            // For max-heap: increase key to +inf, then extractMax
            increaseKey(index, Integer.MAX_VALUE);
            extractRoot();
        }
    }
}
