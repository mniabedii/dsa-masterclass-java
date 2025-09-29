package com.github.mniabedii.linkedlist;

public class Main {
    public static void main(String[] args) {

        // Singly LL:
        SinglyLinkedList l1 = new SinglyLinkedList();
        System.out.println(l1);

        l1.addFirst(50);
        System.out.println(l1);

        l1.addFirst(22);
        System.out.println(l1);

        l1.addLast(22);
        System.out.println(l1);

        l1.addLast(54);
        System.out.println(l1);

        l1.addFirst(32);
        System.out.println(l1);

        l1.addFirst(21);
        System.out.println("end: " + l1);

        l1.removeNode(22);
        System.out.println(l1);

        l1.clear();
        System.out.println(l1);

        ////////////////////////////////////////////////////////////////////////

        // Doubly LL:
        // DoublyLinkedList l2 = new DoublyLinkedList();
        // System.out.println(l2);

        // l2.addFirst(10);
        // System.out.println(l2);

        // l2.addLast(20);
        // System.out.println(l2);

        // l2.addFirst(5);
        // System.out.println(l2);

        // l2.addLast(30);
        // System.out.println("After inserts: " + l2);

        // // reverse
        // l2.reverse();
        // System.out.println("After reverse: " + l2);

        // // traverse forward & backward
        // System.out.print("Traverse forward: ");
        // l2.traverseForward();
        // System.out.print("Traverse backward: ");
        // l2.traverseBackward();

        // // remove head
        // l2.removeHead();
        // System.out.println("After removeHead: " + l2);

        // // remove tail
        // l2.removeTail();
        // System.out.println("After removeTail: " + l2);

        // // remove by value
        // l2.removeNode(20);
        // System.out.println("After removeNode(20): " + l2);

        // // insert at index
        // l2.insertAt(1, 15);
        // System.out.println("After insertAt(1, 15): " + l2);

        // // contains
        // System.out.println("Contains 15? " + l2.contains(15));
        // System.out.println("Contains 100? " + l2.contains(100));

        // // size
        // System.out.println("Size: " + l2.size());

        // // clear
        // l2.clear();
        // System.out.println("After clear: " + l2);

        ////////////////////////////////////////////////////////////////////////

        // // Circular Singly LL
        // CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        // System.out.println(csll);

        // csll.addFirst(10);
        // csll.addLast(20);
        // csll.addLast(30);
        // csll.addFirst(5);
        // System.out.println("After inserts: " + csll);

        // System.out.print("Traverse: ");
        // csll.traverse();

        // csll.removeHead();
        // System.out.println("After removeHead: " + csll);

        // csll.removeTail();
        // System.out.println("After removeTail: " + csll);

        // System.out.println("Contains 20? " + csll.contains(20));
        // System.out.println("Contains 100? " + csll.contains(100));

        ////////////////////////////////////////////////////////////////////////

        // // Cicular Doubly LL:
        // CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
        // System.out.println(cdll);

        // cdll.addFirst(10);
        // cdll.addLast(20);
        // cdll.addLast(30);
        // cdll.addFirst(5);
        // System.out.println("After inserts: " + cdll);

        // System.out.print("Traverse forward: ");
        // cdll.traverseForward();

        // System.out.print("Traverse backward: ");
        // cdll.traverseBackward();

        // cdll.removeHead();
        // System.out.println("After removeHead: " + cdll);

        // cdll.removeTail();
        // System.out.println("After removeTail: " + cdll);

        // System.out.println("Contains 20? " + cdll.contains(20));
        // System.out.println("Contains 100? " + cdll.contains(100));

        // System.out.println("After clear: " + cdll);
    }
}
