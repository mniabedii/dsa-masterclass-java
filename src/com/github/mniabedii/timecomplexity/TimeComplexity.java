package com.github.mniabedii.timecomplexity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.random;

public class TimeComplexity {

    // #1 O(1) - constant time
    public int getElement(int[] arr, int index) {
        return arr[index]; // Takes the same time no matter how long the array is
    }

    // #2 O(lg n) - logarithmic time
    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // #3 O(n) - linear time
    public int sum(int[] arr) {
        int total = 0;
        for (int element : arr) {
            total += element;
        }
        return total;
    }

    // #4 O(n lg(n)) - log-linear time
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];

        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    // #5 O(n^2) - quadratic time
    public void print2DArray(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "," + j);
            }
            System.out.println();
        }
    }

    // #6 O(2^n) - exponential time
    public int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // #7 O(n!) - generate all permutations of a String
    public void permute(String str, String prefix) {
        if (str.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permute(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
            }
        }
    }

    // #8 O(n^n) - generate all functions from a set to itself (all mappings)
    public void generateFunctions(int[] mapping, int position, int n) {
        if (position == n) {
            for (int val : mapping)
                System.out.print(val + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            mapping[position] = i;
            generateFunctions(mapping, position + 1, n);
        }
    }
    // -----------------------------------------------------------------------------------------

    // comparing recursive fibonacci & iterative fibonacci
    // Recursive Fibonacci - O(2^n)
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return 1;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // comparing recrusive & iterative LIS
    // Recursive LIS - O(2^n)
    private static int lisRecursive(int[] arr, int prev, int index) {
        if (index == arr.length)
            return 0;
        int exclude = lisRecursive(arr, prev, index + 1);
        int include = 0;
        if (arr[index] > prev)
            include = 1 + lisRecursive(arr, arr[index], index + 1);
        return Math.max(include, exclude);
    }

    public static int lisRecursive(int[] arr) {
        return lisRecursive(arr, Integer.MIN_VALUE, 0);
    }

    // Patience Sorting LIS - O(nlogn)
    public static int lisPatienceSorting(int[] arr) {
        List<Integer> sub = new ArrayList<>();
        for (int num : arr) {
            int i = Collections.binarySearch(sub, num);
            if (i < 0)
                i = -(i + 1);
            if (i == sub.size())
                sub.add(num);
            else
                sub.set(i, num);
        }
        return sub.size();
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // // Fibonacci
        // for (int i = 0; i < n; i++) {
        // // System.out.println(i + ": " + fibonacciRecursive(i));
        // System.out.println(i + ": " + fibonacciIterative(i));
        // }

        // LIS
        int[] arr1 = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int[] arr2 = { 3, 10, 2, 1, 20, 4, 6, 7, 8, 9,
                15, 25, 5, 11, 13, 50, 60, 70, 80, 90 };

        Random rand = new Random();
        int n = 100;
        int[] arr3 = new int[n];
        for (int i = 0; i < n; i++) {
            arr3[i] = rand.nextInt(1_000_000); // random numbers up to 1 million
        }

        int resPatience = lisPatienceSorting(arr1);
        System.out.println("Patience LIS length: " + resPatience);

        int resNaive = lisRecursive(arr1);
        System.out.println("Naive LIS length: " + resNaive);
    }
}