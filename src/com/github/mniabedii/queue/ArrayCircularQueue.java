package com.github.mniabedii.queue;

public class ArrayCircularQueue {
    int capacity;
    int[] queue;
    int front;
    int rear;
    int size;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Overflow! Queue is full");
            return;
        }

        // Move rear in a circular manner
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow! Queue is empty");
            return -1;
        }

        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Underflow! Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("front -> ");
        for (int i = 0; i < size; i++) {
            s.append(queue[(front + i) % capacity]).append(" -> ");
        }
        s.append("rear");
        return s.toString();
    }
}
