package com.github.mniabedii.linkedlist;

public class DoublyNode {
    int value;
    DoublyNode prevNode;
    DoublyNode nextNode;

    public DoublyNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
