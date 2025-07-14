package com.github.mniabedii.avltree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AVLTree avlTree = new AVLTree();
        while(true) {
            avlTree.insert(scanner.nextInt());
        }
    }
}