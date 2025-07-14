package com.github.mniabedii.redblacktree;

import java.util.Random;
import java.util.Scanner;

public class UserInterface {

    private RedBlackTree redBlackTree;
    private final String cls = "\033[2J\033[H";

    public UserInterface(RedBlackTree redBlackTree) {
        this.redBlackTree = redBlackTree;
    }

    public void welcomeThing() {
        System.out.print(cls);
        System.out.print(Colors.CYAN_BACKGROUND + "---Welcome To Mani's Red-Black Tree---" + Colors.RESET);
        run();
    }

    public void run() {
        showMainMenu();
        int option = choose();
        handleOption(option);
    }

    private void showMainMenu() {
        System.out.println("\n");
        System.out.println(Colors.BLUE_BACKGROUND + "Main Menu" + Colors.RESET);
        System.out.println("\n1. " + Colors.BLUE + "Insertion" + Colors.RESET);
        System.out.println("2. " + Colors.BLUE + "Deletion" + Colors.RESET);
        System.out.println("3. " + Colors.BLUE + "Search" + Colors.RESET);
        System.out.println("4. " + Colors.BLUE + "Rotate Left" + Colors.RESET);
        System.out.println("5. " + Colors.BLUE + "Rotate Right" + Colors.RESET);
        System.out.println("6. " + Colors.BLUE + "Generate Random Tree" + Colors.RESET);
        System.out.println("7. " + Colors.BLUE + "Clear Tree" + Colors.RESET);
        System.out.println("0. " + Colors.RED + "Exit" + Colors.RESET);
    }

    private int choose() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.print("\nChoose From (" + Colors.BLUE + "0" + Colors.RESET + "-" + Colors.BLUE + "7" + Colors.RESET +
                ") to visualise the Red-Black Tree: ");
            option = scanner.nextInt();
        } while (option > 7 || option < 0);
        return option;
    }

    private void handleOption(int option) {
        switch(option) {
            case 0 -> {
                System.out.println(cls);
                System.exit(0);
            } 
            case 1 -> handleInsertion();
            case 2 -> handleDeletion();
            case 3 -> handleSearch();
            case 4 -> handleRotateLeft();
            case 5 -> handleRotateRight();
            case 6 -> handleRandomGenerate();
            case 7 -> handleClearTree();
        }
    }

    private void handleInsertion() {
        System.out.println(cls);
        redBlackTree.printTree();
        System.out.print("\nEnter the value you are willing to insert to the tree: \n");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        redBlackTree.insert(value);
        System.out.println(cls);
        redBlackTree.printTree();

        run();
    }

    private void handleDeletion() {
        System.out.println(cls);
        redBlackTree.printTree();
        System.out.print("\nEnter the value you are willing to delete from the tree: \n");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.println(cls);
        redBlackTree.delete(value);
        redBlackTree.printTree();

        run();
    }

    private void handleSearch() {
        System.out.println(cls);
        redBlackTree.printTree();
        System.out.print("\nEnter the value you are willing to search within the tree: \n");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        redBlackTree.search(value);

        run();
    }

    private void handleRotateLeft() {
        System.out.println(cls);
        redBlackTree.printTree();
        System.out.println();

        System.out.println("After Left Rotation: \n");
        redBlackTree.leftRotate(redBlackTree.getRoot());

        redBlackTree.printTree();
        System.out.println();

        run();
    }

    private void handleRotateRight() {
        System.out.println(cls);
        redBlackTree.printTree();
        System.out.println();

        System.out.println("After Right Rotation: \n");
        redBlackTree.rightRotate(redBlackTree.getRoot());

        redBlackTree.printTree();
        System.out.println();

        run();
    }

    private void handleRandomGenerate() {
        System.out.println(cls);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomValue = random.nextInt(10, 100);
            if (redBlackTree.search(redBlackTree.getRoot(), randomValue) == null)
                redBlackTree.insert(randomValue);
        }
        redBlackTree.printTree();
        System.out.println();

        run();
    }

    private void handleClearTree() {
        System.out.println(cls);
        redBlackTree = new RedBlackTree();
        System.out.println(Colors.GREEN + "Done!" + Colors.RESET);

        run();
    }
}
