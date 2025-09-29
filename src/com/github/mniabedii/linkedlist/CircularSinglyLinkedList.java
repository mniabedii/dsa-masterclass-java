package com.github.mniabedii.linkedlist;

public class CircularSinglyLinkedList {
    private SinglyNode head;
    private SinglyNode tail;

    public SinglyNode getHead() {
        return this.head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // O(n)
    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        SinglyNode current = head;
        do {
            System.out.print(current.value + " -> ");
            current = current.nextNode;
        } while (current != head);
        System.out.println("(back to head)");
    }

    // O(1)
    public void addFirst(int value) {
        SinglyNode newNode = new SinglyNode(value);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.nextNode = head;
        } else {
            newNode.nextNode = head;
            head = newNode;
            tail.nextNode = head;
        }
    }

    // O(1)
    public void addLast(int value) {
        SinglyNode newNode = new SinglyNode(value);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.nextNode = head;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
            tail.nextNode = head;
        }
    }

    // O(1)
    public void removeHead() {
        if (isEmpty())
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.nextNode;
            tail.nextNode = head;
        }
    }

    // O(n)
    public void removeTail() {
        if (isEmpty())
            return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        SinglyNode current = head;
        while (current.nextNode != tail) {
            current = current.nextNode;
        }
        current.nextNode = head;
        tail = current; // releasing the variable
    }

    // O(n)
    public boolean contains(int value) {
        if (isEmpty())
            return false;
        SinglyNode current = head;
        do {
            if (current.value == value)
                return true;
            current = current.nextNode;
        } while (current != head);
        return false;
    }

    // All other methods are similar to Singly LL

    @Override
    public String toString() {
        if (isEmpty())
            return "empty";
        StringBuilder sb = new StringBuilder("head -> ");
        SinglyNode current = head;
        do {
            sb.append(current.value).append(" -> ");
            current = current.nextNode;
        } while (current != head);
        sb.append("(back to head)");
        return sb.toString();
    }
}
