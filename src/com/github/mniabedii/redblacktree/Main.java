package com.github.mniabedii.redblacktree;

public class Main {

    public static void main(String[] args) {

        RedBlackTree redBlackTree = new RedBlackTree();

        UserInterface userInterface = new UserInterface(redBlackTree);
        userInterface.welcomeThing();
    }
}