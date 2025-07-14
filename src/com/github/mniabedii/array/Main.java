package com.github.mniabedii.array;

import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[] array = new int[10];
        Array arrayClass = new Array(array);

        System.out.println(array.length); // returns 10 even though the array is empty

        // insert
        arrayClass.insert(0, 0);
        arrayClass.insert(1, 1);
        arrayClass.insert(2, 2);
        arrayClass.insert(3, 3);
        arrayClass.insert(4, 4);
        arrayClass.insert(5, 5);
        arrayClass.insert(6, 6);
        arrayClass.insert(7, 7);

        //
        System.out.println("After insertion: ");
        arrayClass.print();
        //

        // access
        System.out.println("at index 5: " + arrayClass.access(5));
        System.out.println("at index 2: " + arrayClass.access(2));

        // delete
        arrayClass.delete(5);
        //
        System.out.println("After first deletion: ");
        arrayClass.print();
        //

        arrayClass.delete(2);
        //
        System.out.println("After second deletion: ");
        arrayClass.print();
        //

        // update
        arrayClass.update(5, 21);
        //
        System.out.println("After first update: ");
        arrayClass.print();
        //

        arrayClass.update(8, 22);
        //
        System.out.println("After second update: ");
        arrayClass.print();
        //

        // print
        System.out.println("After all: ");
        arrayClass.print();

        // Search
        System.out.println(arrayClass.linearSearch(22));
        System.out.println(arrayClass.linearSearch(30));
        
        Arrays.sort(array);
        System.out.println(arrayClass.binarySearch(22));
        System.out.println(arrayClass.binarySearch(30));
    }
}
