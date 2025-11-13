package com.github.mniabedii.binarytree;

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Insertion:
    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            root = newNode;
            return;
        }
        recursiveInsert(root, value);
    }

    private void recursiveInsert(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        if (value < root.value) {
            if (root.left == null) {
                root.left = newNode;
                return;
            }
            recursiveInsert(root.left, value);

        } else if (value > root.value) {
            if (root.right == null) {
                root.right = newNode;
                return;
            }
            recursiveInsert(root.right, value);
        }
    }

    // Searching:
    public boolean search(int value) {
        return recursiveSearch(root, value);
    }

    private boolean recursiveSearch(TreeNode root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;
        else if (value < root.value)
            return recursiveSearch(root.left, value);
        else
            return recursiveSearch(root.right, value);
    }

    // Traversal:
    // BFS Traversal is the same as normal binary tree
    public void inOrder() {
        recursiveInOrder(root);
    }

    private void recursiveInOrder(TreeNode root) {
        recursiveInOrder(root.left);
        System.out.println(root.value);
        recursiveInOrder(root.right);
    }

    // find min & max
    public TreeNode findMin(TreeNode root) {
        if (root == null)
            return null;
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public TreeNode findMax() {
        if (root == null)
            return null;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    // Deletion:
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode current, int value) {
        // Base case: if the tree is empty or the value is not found
        if (current == null) {
            return null;
        }

        // Traverse the tree to find the node
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
        } else {
            // value is found

            // Case 1: Node with no left child
            if (current.left == null) {
                return current.right;
            }
            // Case 2: Node with no right child
            else if (current.right == null) {
                return current.left;
            }

            // Case 3: Node with two children
            // Find the in-order successor (smallest node in the right subtree)
            TreeNode minLargerNode = findMin(current.right);
            current.value = minLargerNode.value; // Replace current node's value with successor's value

            // Delete the in-order successor
            current.right = deleteRecursive(current.right, minLargerNode.value);
        }
        return current; // Return the updated node
    }

}
