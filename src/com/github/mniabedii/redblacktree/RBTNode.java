package com.github.mniabedii.redblacktree;

public class RBTNode {
    // We are not using generics so we have to use Integer class to use null as a value
    int value;
    RBTNode left, right, parent;
    NodeColor color;

    public RBTNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = NodeColor.RED;
    }
}