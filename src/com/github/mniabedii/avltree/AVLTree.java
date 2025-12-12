package com.github.mniabedii.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    AVLNode root;

    // root setter
    public void setRoot(AVLNode root) {
        this.root = root;
    }

    // Utility function to get the height of a node
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Utility function to get the balance factor of a node
    private int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotation function
    private AVLNode rightRotate(AVLNode n) {
        AVLNode x = n.left;
        AVLNode xr = x.right;

        // perform rotation
        x.right = n;
        n.left = xr;

        // Update heights
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotation function
    private AVLNode leftRotate(AVLNode n) {
        AVLNode x = n.right;
        AVLNode xl = x.left;

        // Perform rotation
        x.left = n;
        n.right = xl;

        // Update heights
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // INSERTION:

    // public insert only takes the value
    public void insert(int value) {
        root = insert(root, value);
    }

    // but there must be a private insert to overwrite the existing tree
    private AVLNode insert(AVLNode node, int value) {
        // Perform the normal BST insertion
        if (node == null)
            return new AVLNode(value);

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node;

        // update the height & get the new balance
        /*
         * This part also runs, every time that the function is recursively called
         * So, as soon as we get to a node that has imbalance, the balancing function
         * will work
         * THERE IS NOT NECESSARILY A UNIQUE ANSWER TO THIS QUESTION
         * 
         * ... A tree may need to get balanced several times
         */

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        // check to see if the tree has become unbalanced
        if (balance > 1) { // -> Left subtree is heavier

            // Left-Left (LL) Case -> Perform a right rotate
            if (value < node.left.value) { // insertion in the left subtree of the left child
                return rightRotate(node);
            }

            // Left-Right (LR) Case -> Perform a left rotation on the left child, then a
            // right rotation on the node.
            if (value > node.left.value) { // insertion in the right subtree of the left child
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) { // -> Right subtree is heavier

            // Right-Right (RR) Case -> Perform a left rotate
            if (value > node.right.value) { // insertion in the right subtree of the right child
                return leftRotate(node);
            }

            // Right-Left (RL) Case -> Perform a right rotation on the right child, then a
            // left rotation on the node.
            if (value < node.right.value) { // insertion in the left subtree of the right child
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        // return the new root
        return node;
    }

    // DELETION:

    // public delete method just gets the value
    public void delete(int value) {
        root = delete(root, value);
    }

    // but there must be a private delete method to overwrite the current root
    private AVLNode delete(AVLNode node, int value) {
        // Perform standard BST delete
        if (node == null) {
            return node;
        }

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // Node with one child or no child
            if ((node.left == null) || (node.right == null)) {
                AVLNode temp;
                if (node.left != null)
                    temp = node.left;
                else
                    temp = node.right;

                // Not & One child case
                node = temp;
            } else {
                // Node with two children: Get the inorder successor
                AVLNode temp = inOrderSuccessor(node);

                // Copy the inorder successor's key to this node
                node.value = temp.value;

                // Delete the inorder successor
                node.right = delete(node.right, temp.value);
            }
        }

        // If the tree had only one node, return null
        if (node == null)
            return null;

        // Update height of the current node & get the new balance
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        // check to see if the tree has become unbalanced
        if (balance > 1) { // Left subtree is heavier (deletion in right subtree)

            // Left-Left (LL) Case
            if (getBalance(node.left) >= 0) { // left side is heavier
                return rightRotate(node);
            }

            // Left-Right (LR) Case
            if (getBalance(node.left) < 0) { // right side is heavier
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) { // Right subtree is heavier (deletion in left subtree)

            // Right-Right (RR) Case
            if (getBalance(node.right) <= 0) { // right side is heavier
                return leftRotate(node);
            }

            // Right-Left (RL) Case
            if (getBalance(node.right) > 0) { // left side is heavier
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        // Return the new node
        return node;
    }

    // Utility function to find the node with the smallest key
    private AVLNode inOrderSuccessor(AVLNode node) {
        AVLNode current = node.right;

        // Loop down to find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // SEARCH:

    // the same as standard BST search
    private AVLNode search(int value) {
        return search(root, value);
    }

    public AVLNode search(AVLNode node, int value) {
        // Base case: root is null or key is present at the root
        if (node == null || node.value == value)
            return node;

        // Value is smaller than root's value
        if (value < node.value) {
            return search(node.left, value);
        }

        // Value is greater than root's value
        return search(node.right, value);
    }

    // TRAVERSALS:

    // Level-Order traversal of the AVL Tree
    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        // Initialize a queue to store nodes to be processed
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);

        AVLNode currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();

            // Print the current node's value
            System.out.print(currentNode.value + " ");

            // Enqueue left child if it exists
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            // Enqueue right child if it exists
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

        System.out.println(); // For a new line after traversal
    }

    // In-order traversal of the AVL tree
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    // Pre-order traversal of the AVL tree
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Post-order traversal of the AVL tree
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(AVLNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, 0);
        return sb.toString();
    }

    private void buildString(AVLNode node, StringBuilder sb, int depth) {
        if (node == null) {
            sb.append("  ".repeat(depth)).append("null\n");
            return;
        }
        sb.append("  ".repeat(depth)).append(node.value).append(" (h=").append(node.height).append(")\n");
        buildString(node.left, sb, depth + 1);
        buildString(node.right, sb, depth + 1);
    }
}