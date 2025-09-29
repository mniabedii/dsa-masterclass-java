package com.github.mniabedii.linkedlist;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;

    // O(1)
    public DoublyNode getHead() {
        return this.head;
    }

    public DoublyNode getTail() {
        return this.tail;
    }

    // Traversing forward
    // O(n)
    public void traverseForward() {
        DoublyNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode + " <-> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println("null");
    }

    // Traversing backward
    // O(n)
    public void traverseBackward() {
        DoublyNode currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode + " <-> ");
            currentNode = currentNode.prevNode;
        }
        System.out.println("null");
    }

    // Add to Front
    // O(1)
    public void addFirst(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.nextNode = head;
            head.prevNode = newNode;
            head = newNode;
        }
    }

    // Add to end
    // O(1)
    public void addLast(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }
    }

    // Remove head
    // O(1)
    public void removeHead() {
        if (head == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.nextNode;
            head.prevNode = null;
        }
    }

    // Remove tail
    // O(1)
    public void removeTail() {
        if (tail == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prevNode;
            tail.nextNode = null;
        }
    }

    // Remove first occurrence of value
    // O(n)
    public void removeNode(int value) {
        DoublyNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                if (currentNode == head) {
                    removeHead();
                } else if (currentNode == tail) {
                    removeTail();
                } else {
                    currentNode.prevNode.nextNode = currentNode.nextNode;
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                }
                return;
            }
            currentNode = currentNode.nextNode;
        }
    }

    // O(n)
    public boolean contains(int value) {
        DoublyNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    // O(n)
    public int size() {
        int count = 0;
        DoublyNode currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.nextNode;
        }
        return count;
    }

    // O(n)
    public DoublyNode findNodeByIndex(int index) {
        if (index < 0)
            return null;
        DoublyNode currentNode = head;
        while (currentNode != null && index > 0) {
            currentNode = currentNode.nextNode;
            index--;
        }
        return currentNode;
    }

    // Insert
    // O(n)
    public void insertAt(int index, int value) {
        if (index < 0 || index > size())
            return;

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size()) {
            addLast(value);
            return;
        }

        DoublyNode prevNode = findNodeByIndex(index - 1);
        if (prevNode == null)
            return;

        DoublyNode newNode = new DoublyNode(value);
        DoublyNode nextNode = prevNode.nextNode;

        newNode.nextNode = nextNode;
        newNode.prevNode = prevNode;
        prevNode.nextNode = newNode;
        nextNode.prevNode = newNode;
    }

    // Reverse list in-place
    // O(n)
    public void reverse() {
        /*
         * Why doesnt this work?
         * temp = head;
         * head = tail;
         * tail = temp;
         */
        DoublyNode currentNode = head;
        DoublyNode temp = null;
        while (currentNode != null) {
            temp = currentNode.prevNode;
            currentNode.prevNode = currentNode.nextNode;
            currentNode.nextNode = temp;
            currentNode = currentNode.prevNode;
        }
        if (temp != null) {
            tail = head;
            head = temp.prevNode;
        }
    }

    public void clear() {
        head = tail = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head <-> ");
        DoublyNode currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.value).append(" <-> ");
            currentNode = currentNode.nextNode;
        }
        sb.append("null");
        return sb.toString();
    }
}
