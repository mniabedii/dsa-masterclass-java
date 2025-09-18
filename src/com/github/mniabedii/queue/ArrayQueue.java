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

        // Queue is empty
        if (isEmpty()) {
            front = rear = 0;
            queue[rear] = value;
            return;
        }

        // Queue is not full or empty
        queue[rear++] = value;
    }

    public int dequeue() {
        // Rear won't change, change will be from front

        // Queue is empty
        if (isEmpty()) {
            System.out.println("Underflow! Queue is empty");
            return -1;
        }

        // Queue has only one element
        if (front == rear) {
            int value = queue[rear];
            front = rear = -1;
            return value;
        }

        // Queue has more than one element
        return queue[front++];
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
        return rear == front && front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("front -> ");
        for (int i = front; i <= rear; i++) {
            s.append(queue[i]).append(" -> ");
        }
        s.append("rear");
        return s.toString();
    }
}