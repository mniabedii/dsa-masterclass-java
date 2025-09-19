package com.github.mniabedii.linkedlist;

public class SinglyNode {
    int value;
    SinglyNode nextNode;

    public SinglyNode(int value) {
        this.value = value;
        this.nextNode = null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
