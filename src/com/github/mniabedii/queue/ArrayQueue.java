package com.github.mniabedii.queue;

public class ArrayQueue {

    int capacity;
    int[] queue;
    int front;
    int rear;

    public ArrayQueue(int capacity) {
        front = rear = -1;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void enqueue(int value) {
        // Front won't change, change will be from rear

        // Queue is full
        if (isFull()) {
            System.out.println("Overflow! Queue is full");
            return;
        }

        queue[++rear] = value;
    }

    public int dequeue() {
        // Rear won't change, change will be from front

        // Queue is empty
        if (isEmpty()) {
            System.out.println("Underflow! Queue is empty");
            return -1;
        }

        return queue[++front];
    }

    public int peek() {
        // Queue is empty
        if (isEmpty()) {
            System.out.println("Underflow! Queue is empty");
            return -1;
        }

        return queue[front];
    }

    public int size() {
        if (isEmpty())
            return 0;

        return rear - front + 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("front -> ");
        for (int i = front + 1; i <= rear; i++) {
            s.append(queue[i]).append(" -> ");
        }
        s.append("rear");
        return s.toString();
    }
}