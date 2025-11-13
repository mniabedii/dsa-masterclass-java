package com.github.mniabedii.binarytree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }

    public String toString() {
        return String.valueOf(value);
    }

}
