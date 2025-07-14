package com.github.mniabedii.array;

public class Array {

    private int[] array;
    public int currentSize; // needed for insert & delete

    public Array(int[] array) {
        this.array = array;
        this.currentSize = 0;
    }

    // 1. Access - O(1)
    public int access(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    // 2. Insert - O(n)
    public void insert(int index, int value) {
        if (currentSize == array.length) {
            throw new RuntimeException("Array full");
        }
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = currentSize - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
        currentSize++;
    }

    // 3. Delete - O(n)
    public void delete(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < currentSize - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--currentSize] = 0;
    }

    // Update - O(1)
    public int update(int index, int newValue) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        int temp = array[index];
        array[index] = newValue;
        return temp;
    }

    // Search
    // Linear Search - O(n)
    public int linearSearch(int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // found at index i
            }
        }
        return -1; // not found
    }

    // Binary Search - O(log n)
    // on sorted array
    public int binarySearch(int target) {
        int low = 0, high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid; // found
            } else if (array[mid] < target) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }
        return -1; // not found
    }

    // Print
    public void print() {
        System.out.print("[ ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }
}