package com.github.mniabedii.queue;

public class Main {

    public static void main(String[] args) {

        // False overflow problem --
        ArrayQueue queue = new ArrayQueue(3); // capacity = 3

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue);

        System.out.println("Dequeue: " + queue.dequeue()); // removes 10
        System.out.println(queue);

        System.out.println("Dequeue: " + queue.dequeue()); // removes 20
        System.out.println(queue);

        // At this point: rear = 2 (end of array), front = 2,
        // only one element left (30) at index 2.
        // One free space at index 0 and 1, but rear can’t move → FALSE OVERFLOW.

        queue.enqueue(40); // Should print "Overflow"
        System.out.println(queue);
        // ---

        // Circular Queue overcoming the problem
        ArrayCircularQueue cirQueue = new ArrayCircularQueue(5);

        // Fill the queue
        cirQueue.enqueue(1);
        cirQueue.enqueue(2);
        cirQueue.enqueue(3);
        cirQueue.enqueue(4);
        cirQueue.enqueue(5);
        System.out.println(cirQueue); // front -> 1 -> 2 -> 3 -> 4 -> 5 -> rear

        // Dequeue 2 elements
        System.out.println("Dequeue: " + cirQueue.dequeue()); // 1
        System.out.println("Dequeue: " + cirQueue.dequeue()); // 2
        System.out.println(cirQueue); // front -> 3 -> 4 -> 5 -> rear

        // Enqueue 2 more elements, should wrap around
        cirQueue.enqueue(6);
        cirQueue.enqueue(7);
        System.out.println(cirQueue); // front -> 3 -> 4 -> 5 -> 6 -> 7 -> rear

        // Try enqueue on full queue
        cirQueue.enqueue(8); // Overflow! Queue is full

    }
}