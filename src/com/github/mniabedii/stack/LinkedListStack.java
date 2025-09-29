package com.github.mniabedii.stack;

import com.github.mniabedii.linkedlist.*;

public class LinkedListStack {
    private SinglyLinkedList list;

    public LinkedListStack() {
        list = new SinglyLinkedList();
    }

    // dynamically sized so no overflow

    // Push = addFirst
    public void push(int data) {
        list.addFirst(data);
    }

    // Pop = removeHead
    public int pop() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        int value = list.getHead().value;
        list.removeHead();
        return value;
    }

    // Peek = head value
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return list.getHead().value;
    }

    // Empty check
    public boolean isEmpty() {
        return list.getHead() == null;
    }

    // Print stack top to bottom
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SinglyLinkedList tempList = list; // traverse from head
        sb.append(list.toString().replace("head -> ", "").replace(" -> null", ""));
        return sb.toString().replace(" -> ", "\n__\n\n");
    }
}
