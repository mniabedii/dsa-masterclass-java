package com.github.mniabedii.avltree;

public class AVLNode {
    int value, height;
    AVLNode left, right;

    public AVLNode(int value) {
        this.right = this.left = null;
        this.value = value;
        this.height = 1; // Height of a new node is 1
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
