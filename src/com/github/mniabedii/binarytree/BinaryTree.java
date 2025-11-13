package com.github.mniabedii.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // Insertion:
    // Level-Order insertion:
    public void levelOrderInsert(int value) {
        TreeNode newNode = new TreeNode(value);

        // if the tree is empty
        if (root == null) {
            root = newNode;
            return;
        }

        /*
         * use a queue for level-order traversal
         * because the left child is added first & we want it to be processed first
         * this satisfies the FIFO principle
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // so the root is the only element in queue

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // .poll() retrieves and removes the head of the queue

            /*
             * check the left child, if it is empty put it there
             * otherwise add the left child to the queue to be processed like a root
             */
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            // Check right child
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Deletion:
    public void deleteNode(int value) {
        if (root == null)
            return;

        // If the tree has only one node
        if (root.left == null && root.right == null) {
            if (root.value == value) {
                root = null; // Deleting the root itself
            } else {
                System.out.println("Node not found");
                return;
            }
            return;
        }

        // Perform level order traversal to find the node to delete
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode targetNode = null;
        TreeNode deepestNode = null, parentOfDeepest = null;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Check if the current node is the target node
            if (current.value == value) {
                targetNode = current;
            }

            // Track the parent of the deepest node
            if (current.left != null) {
                parentOfDeepest = current;
                queue.add(current.left);
            }
            if (current.right != null) {
                parentOfDeepest = current;
                queue.add(current.right);
            }

            // Update deepest node
            deepestNode = current;
        }

        // If the node to delete was not found
        if (targetNode == null) {
            System.out.println("Node not found");
            return;
        }

        // Replace the target node's value with the deepest node's value
        targetNode.value = deepestNode.value;

        // Delete the deepest node
        if (parentOfDeepest != null) {
            if (parentOfDeepest.left == deepestNode) {
                parentOfDeepest.left = null;
            } else {
                parentOfDeepest.right = null;
            }
        }
    }

    // Searching:
    // Linear search is used when the tree is implemented by array
    // DFS Search:
    public boolean search(TreeNode root, int target) {
        if (root == null) {
            return false; // Base case: if the tree is empty or node is null
        }

        if (root.value == target) {
            return true; // Found the target
        }

        // Search in left and right subtrees
        return search(root.left, target) || search(root.right, target);
    }

    // Traversals:
    // DFS Traversals:
    public void preOrder(TreeNode root) {
        // PreOrder = Root -> Left -> Right

        // Base case:
        if (root == null)
            return;

        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        // InOrder = Left -> Root -> Right
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.right);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        // postOrder = Left -> Right -> Root

        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root);
    }

    // BFS Traversal:
    public void levelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            System.out.println(current + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    @Override
    public String toString() {

        // if the tree is empty
        if (root == null) {
            return null;
        }

        /*
         * use a queue for level-order traversal
         * because the left child is added first & we want it to be processed first
         * this satisfies the FIFO principle
         */

        String s = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // so the root is the only element in queue

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // .poll() retrieves and removes the head of the queue

            /*
             * check the left child, if it is empty put it there
             * otherwise add the left child to the queue to be processed like a root
             */
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
            s += current.toString() + " -> ";
        }
        s += null;
        return s;
    }
}
