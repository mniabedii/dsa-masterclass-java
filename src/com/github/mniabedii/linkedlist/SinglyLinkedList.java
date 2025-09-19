package com.github.mniabedii.linkedlist;

public class SinglyLinkedList {
    SinglyNode head;

    // first node of the linked list
    public SinglyNode getHead() {
        return this.head;
    }

    // traversing method in linked list
    // O(n)
    public void traverseList() {
        SinglyNode currentNode = head;
        SinglyNode prevNode = null;

        while (currentNode != null) {
            System.out.println(currentNode);
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    // Adds to the front(head) of the linked list
    // O(1)
    public void addFirst(int value) {
        SinglyNode newNode = new SinglyNode(value);
        newNode.nextNode = head;
        head = newNode;
    }

    // Adds to the rear(tail) of the linked list
    // O(n)
    public void addLast(int value) {
        SinglyNode newNode = new SinglyNode(value);

        // empty list
        if (head == null) {
            head = newNode;
            return;
        }

        SinglyNode currentNode = head;
        SinglyNode prevNode = null;
        while (currentNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        prevNode.nextNode = newNode;
    }

    // Removes the first element of the list
    // O(1)
    public void removeHead() {
        // empty list
        if (head == null)
            return;

        // only one element
        if (head.nextNode == null) {
            head = null;
            return;
        }

        head = head.nextNode;
    }

    // Removes nodes based on value
    // O(n)
    public void removeNode(int value) {
        // empty list
        if (head == null)
            return;

        // only one element
        if (head.value == value && head.nextNode == null) {
            head = null;
            return;
        }

        // when the value matches teh head
        while (head != null && head.value == value) {
            head = head.nextNode;
        }

        // Traverse and remove nodes in the middle
        SinglyNode currentNode = head;
        SinglyNode prevNode = null;

        while (currentNode != null) {
            if (currentNode.value == value) {
                prevNode.nextNode = currentNode.nextNode;
                currentNode = currentNode.nextNode;
                continue; // skip updating prevNode
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    // O(n)
    public boolean contains(int value) {
        SinglyNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    // O(n)
    public int size() {
        int count = 0;
        SinglyNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.nextNode;
            count++;
        }
        return count;
    }

    // O(n)
    public SinglyNode findNodeByIndex(int index) {
        if (index < 0)
            return null;
        SinglyNode currentNode = head;
        while (currentNode != null && index > 0) {
            currentNode = currentNode.nextNode;
            index--;
        }
        return currentNode;
    }

    // Insert at the middle
    // O(n)
    public void insertAt(int index, int value) {
        if (index < 0 || index > size())
            return;

        if (index == 0) {
            addFirst(value);
            return;
        }

        SinglyNode prevNode = findNodeByIndex(index - 1);
        if (prevNode == null)
            return;

        SinglyNode newNode = new SinglyNode(value);
        newNode.nextNode = prevNode.nextNode;
        prevNode.nextNode = newNode;
    }

    // Reversing the linked list
    // O(n)
    // O(n)
    public void reverse() {
        SinglyNode currentNode = head;
        SinglyNode prevNode = null;
        SinglyNode nextNode;
        while (currentNode != null) {
            // 4 pointer changes needed
            nextNode = currentNode.nextNode;
            currentNode.nextNode = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
    }

    public void clear() {
        head = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head -> ");
        SinglyNode currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.value).append(" -> ");
            currentNode = currentNode.nextNode;
        }
        sb.append("null");
        return sb.toString();
    }
}
