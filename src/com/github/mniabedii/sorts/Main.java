package com.github.mniabedii.sorts;

public class Main {

    public static void main(String[] args) {

        int[] list = { 5, 3, 8, 1, 3, 7, 2, 5 };

        MergeSort.mergeSort(list);

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}