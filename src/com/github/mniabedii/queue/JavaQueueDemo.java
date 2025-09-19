package com.github.mniabedii.queue;

import java.util.*;

public class JavaQueueDemo {
    public static void main(String[] args) {
        // Java provides a built-in Queue interface
        // Here we use LinkedList as an implementation of Queue
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue elements (add to the rear)
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Queue after enqueue operations: " + queue);

        // Dequeue element (remove from the front)
        int removed = queue.remove();
        System.out.println("Dequeued element: " + removed);
        System.out.println("Queue after dequeue: " + queue);

        // Peek at the front element (without removing)
        int front = queue.peek();
        System.out.println("Front element: " + front);

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
