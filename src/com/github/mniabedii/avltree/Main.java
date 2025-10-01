package com.github.mniabedii.avltree;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert some nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // triggers rotation
        tree.insert(40);
        tree.insert(50);
        tree.insert(25); // another balancing case

        System.out.println("Tree after insertions: ");
        System.out.println(tree);

        // Traversals
        System.out.print("In-order: ");
        tree.inOrder();
        System.out.println();

        System.out.print("Pre-order: ");
        tree.preOrder();
        System.out.println();

        System.out.print("Post-order: ");
        tree.postOrder();
        System.out.println();

        System.out.print("Level-order: ");
        tree.levelOrder();

        // Search
        System.out.println("Searching for 25: " + (tree.search(tree.root, 25) != null));
        System.out.println("Searching for 99: " + (tree.search(tree.root, 99) != null));

        // Deletion
        tree.delete(40);
        System.out.println("\nTree after deleting 40:");
        System.out.println(tree);

        tree.delete(10);
        System.out.println("Tree after deleting 10:");
        System.out.println(tree);

        tree.delete(30);
        System.out.println("Tree after deleting 30:");
        System.out.println(tree);
    }
}
