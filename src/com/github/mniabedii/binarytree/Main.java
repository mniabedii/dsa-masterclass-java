package com.github.mniabedii.binarytree;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.levelOrderInsert(5);
        binaryTree.levelOrderInsert(6);
        binaryTree.levelOrderInsert(5);
        binaryTree.levelOrderInsert(8);
        binaryTree.levelOrderInsert(41);
        binaryTree.levelOrderInsert(22);
        binaryTree.levelOrderInsert(2);
        binaryTree.levelOrderInsert(12);
        binaryTree.levelOrderInsert(9);

        TreeNode newNode = new TreeNode(10);
        System.out.println(binaryTree);
    }
}