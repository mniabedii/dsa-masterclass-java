package com.github.mniabedii.queue;

import com.github.mniabedii.linkedlist.*;

public class LinkedListQueue {
    private CircularSinglyLinkedList list;

    public LinkedListQueue() {
        list = new CircularSinglyLinkedList();
    }

    // Enqueue = addLast
    public void enqueue(int data) {
        list.addLast(data);
    }

    // Dequeue = removeHead
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        int value = list.getHead().value;
        list.removeHead();
        return value;
    }

    // Peek front
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return list.getHead().value;
    }

    // Size
    public int size() {
        return list.size();
    }

    // Empty check
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Print queue front to rear
    @Override
    public String toString() {
        if (isEmpty())
            return "empty";
        StringBuilder sb = new StringBuilder();
        CircularSinglyLinkedList.SinglyNode current = list.getHead();
        do {
            sb.append(current.value).append("\n__\n\n");
            current = current.nextNode;
        } while (current != list.getHead());
        return sb.toString();
    }
}
