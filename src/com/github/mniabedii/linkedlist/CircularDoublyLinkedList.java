package com.github.mniabedii.linkedlist;

public class CircularDoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    // O(n)
    public void traverseForward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        DoublyNode current = head;
        do {
            System.out.print(current.value + " <-> ");
            current = current.nextNode;
        } while (current != head);
        System.out.println("(back to head)");
    }

    // O(n)
    public void traverseBackward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        DoublyNode current = tail;
        do {
            System.out.print(current.value + " <-> ");
            current = current.prevNode;
        } while (current != tail);
        System.out.println("(back to tail)");
    }

    // O(1)
    public void addFirst(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (isEmpty()) {
            head = tail = newNode;
            head.nextNode = head.prevNode = head;
        } else {
            newNode.nextNode = head;
            newNode.prevNode = tail;
            head.prevNode = newNode;
            tail.nextNode = newNode;
            head = newNode;
        }
    }

    // O(1)
    public void addLast(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (isEmpty()) {
            head = tail = newNode;
            head.nextNode = head.prevNode = head;
        } else {
            newNode.prevNode = tail;
            newNode.nextNode = head;
            tail.nextNode = newNode;
            head.prevNode = newNode;
            tail = newNode;
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
            head.prevNode = tail;
            tail.nextNode = head;
        }
    }

    // O(1)
    public void removeTail() {
        if (isEmpty())
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prevNode;
            tail.nextNode = head;
            head.prevNode = tail;
        }
    }

    // O(n)
    public boolean contains(int value) {
        if (isEmpty())
            return false;
        DoublyNode current = head;
        do {
            if (current.value == value)
                return true;
            current = current.nextNode;
        } while (current != head);
        return false;
    }

    // All other methods are similar to Doubly LL

    @Override
    public String toString() {
        if (isEmpty())
            return "empty";
        StringBuilder sb = new StringBuilder("head <-> ");
        DoublyNode current = head;
        do {
            sb.append(current.value).append(" <-> ");
            current = current.nextNode;
        } while (current != head);
        sb.append("(back to head)");
        return sb.toString();
    }

}
