package com.github.mniabedii.redblacktree;

public class RedBlackTree {

    private RBTNode root;
    private final RBTNode nil;
     /* nil is A sentinel node that represents a null in the Red-Black Tree,
     instead of using null we use this to simplify implementations.
     */

    public RedBlackTree() {
       nil = new RBTNode(0);
       nil.color = NodeColor.BLACK; // node is considered black
       nil.left = null;
       nil.right = null;
       
       root = nil;
    }

    public RBTNode getRoot() {
        return root;
    }


    // ROTATIONS:

    public void leftRotate(RBTNode x) {
        if (x == null || x.right == null) return; // Ensure x and its right child are not null
    
        RBTNode y = x.right; // Set y as the right child of x
        x.right = y.left; // Move y's left subtree to x's right child
    
        // Update the parent reference of y's left child, if it exists
        if (y.left != nil) y.left.parent = x;
    
        // Update the parent reference of y
        y.parent = x.parent;
    
        // Update the root of the tree if x was the root
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
    
        // Set x as the left child of y
        y.left = x;
        x.parent = y;
    }
    
    public void rightRotate(RBTNode x) {
        if (x == null || x.left == null) return; // Ensure x and its left child are not null
    
        RBTNode y = x.left; // Set y as the left child of x
        x.left = y.right; // Move y's right subtree to x's left child
    
        // Update the parent reference of y's right child, if it exists
        if (y.right != nil) y.right.parent = x;
    
        // Update the parent reference of y
        y.parent = x.parent;
    
        // Update the root of the tree if x was the root
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
    
        // Set x as the right child of y
        y.right = x;
        x.parent = y;
    }
    

    // INSERTION:

    public void insert(int value) {
        // Standard BST Insertion:

        RBTNode newNode = new RBTNode(value);
        // put left & right to nil
        newNode.left = nil;
        newNode.right = nil; 

        RBTNode currentNode = root;
        RBTNode parentOfCurrentNode = null;

        // find where we have to insert the node
        while (currentNode != nil) {
            parentOfCurrentNode = currentNode;
            if (newNode.value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        newNode.parent = parentOfCurrentNode;
        if (parentOfCurrentNode == null) {
            root = newNode; // Tree was empty

        } else if (newNode.value < parentOfCurrentNode.value) {
            parentOfCurrentNode.left = newNode;
        } else {
            parentOfCurrentNode.right = newNode;
        }

        // Case 1
        if (newNode.parent == null) { // If the new node is now the root
            newNode.color = NodeColor.BLACK; // the root is always black
            return; // No other adjustments needed
        }

        // Case 1
        if (newNode.parent.parent == null) {
            /* if the newNode is the child of the root, no balancing is needed
               because the root is always black & the new node is red so no properties
               has been violated
            */
            return;
        }

        // Otherwise, there might be some violations that need to be fixed
        fixInsertViolations(newNode);
    }

    private void fixInsertViolations(RBTNode node) {
        RBTNode parent, grandparent, uncle;

        while (node != root && node.parent.color == NodeColor.RED) {
            // for every node from our node up to the root
            parent = node.parent;
            grandparent = node.parent.parent;
            uncle = getUncle(node);

            // Case 2.a) Parent is red & uncle is red
            if (uncle != null && uncle.color == NodeColor.RED) {
                parent.color = NodeColor.BLACK;
                uncle.color = NodeColor.BLACK;
                grandparent.color = NodeColor.RED;
                node = grandparent; // Move up to grandparent

            } else {
                // Case 2.b): Parent is red & uncle is black (or null)
                if (parent == grandparent.left) {
                    // Case 2.b.i) Left-Left (LL)
                    if (node == parent.left) {
                        rightRotate(grandparent);
                        swapColors(grandparent, node.parent);
                    } else { // Case 2.b.iii) Left-Right (LR)
                        leftRotate(node.parent);
                        rightRotate(grandparent);
                        swapColors(grandparent, node);
                    }
                } else {
                    // Case 2.b.iv: Right-Left (RL)
                    if (node == parent.left) {
                        rightRotate(node.parent);
                        leftRotate(grandparent);
                        swapColors(grandparent, node);
                    } else { // Case 2.b.ii: Right-Right (RR)
                        leftRotate(grandparent);
                        swapColors(grandparent, node.parent);
                    }
                }
            }
        }
        root.color = NodeColor.BLACK; // The root is always black
    }

    // Helper Methods
    private RBTNode getUncle(RBTNode node) {
        if (node.parent == null || node.parent.parent == null) return null;
        if (node.parent.parent.left == node.parent){
            return node.parent.parent.right;
        } else return node.parent.parent.left;
    }

    private void swapColors(RBTNode node1, RBTNode node2) {
        NodeColor temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }


    // DELETION:

    public void delete(int value) {
        // Perform a standard BST Deletion:

        RBTNode nodeToBeDeleted = findNodeToDelete(root, value);
        if (nodeToBeDeleted == nil) {
            System.out.println(Colors.RED + "Node to be deleted not found\n" + Colors.RESET);
            return;
        }
    
        RBTNode actuallyDeletingNode = nodeToBeDeleted;
        RBTNode replacingNode = nil; // This will replace the actuallyDeletingNode
        NodeColor originalColorOfActualDeleting = actuallyDeletingNode.color;
    
        if (nodeToBeDeleted.left == nil) {
            // If the tree only has right child, replace it with the right child
            replacingNode = nodeToBeDeleted.right;
            transplant(nodeToBeDeleted, nodeToBeDeleted.right);
        } else if (nodeToBeDeleted.right == nil) {
            // If the tree only has left child, replace it with the left child
            replacingNode = nodeToBeDeleted.left;
            transplant(nodeToBeDeleted, nodeToBeDeleted.left);
        } else {
            // The tree has two children
            // in this case replacing node that is actually being deleted, is the in-order successor
            actuallyDeletingNode = successor(nodeToBeDeleted.right);
            originalColorOfActualDeleting = actuallyDeletingNode.color;
            replacingNode = actuallyDeletingNode.right; // This might be null, but we have to keep it
            // the successor wont have a left child but it can have a left child

            // Now There is a speacial case here:
            if (actuallyDeletingNode.parent == nodeToBeDeleted) {
                // the successor is the right child of the node that is being deleted.
                replacingNode.parent = actuallyDeletingNode;
            } else {
                // Otherwise:
                transplant(actuallyDeletingNode, actuallyDeletingNode.right);
                actuallyDeletingNode.right = nodeToBeDeleted.right;
                actuallyDeletingNode.right.parent = actuallyDeletingNode;
            }

            // replace nodeToBeDeleted & the node that actually gets deleted
            transplant(nodeToBeDeleted, actuallyDeletingNode);
            actuallyDeletingNode.left = nodeToBeDeleted.left;
            actuallyDeletingNode.left.parent = actuallyDeletingNode;
            actuallyDeletingNode.color = nodeToBeDeleted.color;
        }
    
        // if the node that is actually deleted was black, there will be violations
        if (originalColorOfActualDeleting == NodeColor.BLACK) {
            fixDeleteViolations(replacingNode);
        }
    }
    
    private void fixDeleteViolations(RBTNode node) {
        RBTNode sibling;

        while(node != root && node.color == NodeColor.BLACK) {

            if (node == node.parent.left) {
                sibling = node.parent.right;

                // Case 1: The sibling is red:
                if (sibling.color == NodeColor.RED) {
                    sibling.color = NodeColor.BLACK;
                    node.parent.color = NodeColor.RED;
                    leftRotate(node.parent);
                    sibling = node.parent.right;
                    // Falls into one of the cases below (Sibling are all black in below cases)
                } 
                
                // Case 2: both its children are black 
                if (sibling.left.color == NodeColor.BLACK && 
                    sibling.right.color == NodeColor.BLACK) { // Both its children are black
                    sibling.color = NodeColor.RED;
                    node = node.parent; // do the same thing on the parent

                // Case 3: sibling's closer child to the node is red & its other child is black
                } else { 
                    if (sibling.right.color == NodeColor.BLACK) {
                        sibling.left.color = NodeColor.BLACK;
                        sibling.color = NodeColor.RED;
                        rightRotate(sibling);
                        sibling = node.parent.right; //falls into case 4
                    }

                    // Case 4: sibling's farther child to the node is red 
                    sibling.color = node.parent.color;
                    node.parent.color = NodeColor.BLACK;
                    sibling.right.color = NodeColor.BLACK;
                    leftRotate(node.parent);
                        
                    node = root; // do this to break the code
                }
            } else {
                sibling = node.parent.left;

                // Case 1: The sibling is red:
                if (sibling.color == NodeColor.RED) {
                    sibling.color = NodeColor.BLACK;
                    node.parent.color = NodeColor.RED;
                    rightRotate(node.parent);
                    sibling = node.parent.left;
                    // Falls into one of the cases below (Sibling are all black in below cases)
                } 
                
                // Case 2: both its children are black 
                if (sibling.left.color == NodeColor.BLACK && 
                    sibling.right.color == NodeColor.BLACK) { // Both its children are black
                    sibling.color = NodeColor.RED;
                    node = node.parent; // do the same thing on the parent

                // Case 3: sibling's closer child to the node is red & its other child is black
                } else { 
                    if (sibling.left.color == NodeColor.BLACK) {
                        sibling.right.color = NodeColor.BLACK;
                        sibling.color = NodeColor.RED;
                        leftRotate(sibling);
                        sibling = node.parent.left; //falls into case 4
                    }

                    // Case 4: sibling's farther child to the node is red 
                    sibling.color = node.parent.color;
                    node.parent.color = NodeColor.BLACK;
                    sibling.left.color = NodeColor.BLACK;
                    rightRotate(node.parent);
                        
                    node = root; // do this to break the code
                }
            }
        }
        node.color = NodeColor.BLACK;
    }

    // Helper Methods:
    
    private void transplant(RBTNode node1, RBTNode node2) {
        // This method replaces node2 with node 1, removing node 1

        // node 1 is the root
        if (node1.parent == null) {
            root = node2;
        } else if (node1 == node1.parent.left) {
            node1.parent.left = node2;
        } else {
            node1.parent.right = node2;
        }
        node2.parent = node1.parent;       
    }

    private RBTNode findNodeToDelete(RBTNode node, int value) {
        while(node != nil) {
            if (node.value == value) {
                return node;
            } else if (node.value < value) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return nil;
    }

    private RBTNode successor(RBTNode node) {
        while (node.left != nil)
            node = node.left;
        return node;
    }

    // SEARCH:
    // the same as standard BST search
    public void search(int value) {
        if (search(root, value) == null) {
            System.out.println(Colors.RED + "Not Found!" + Colors.RESET);
        } else {
            System.out.println(Colors.GREEN + "Found!" + Colors.RESET);
        }
    }
    
    public RBTNode search(RBTNode node, int value) {
        // Base case: root is null or key is present at the root
        if (node == nil) return null;
        if (node.value == value) return node;

        // Value is smaller than root's value
        if (value < node.value) {
            return search(node.left, value);
        }

        // Value is greater than root's value
        return search(node.right, value);
    }

    // PRINT:
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(RBTNode node, String indent, boolean isLeft) {
        String plus;
        if (node != nil) {
            if (isLeft) {
                plus = "│   ";
            } else plus = "    ";

            printTree(node.right, indent + plus, false);

            if (isLeft) {
                plus = "└── ";
            } else plus = "┌── ";

            System.out.println(indent + plus + node.color.getColor() + node.value + Colors.RESET);
            printTree(node.left, indent + ("    "), true);
        }
    }
   
}