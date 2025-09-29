package com.github.mniabedii.linkedlist;

public class Main {
    public static void main(String[] args) {

        // // Singly LL:
        // SinglyLinkedList l1 = new SinglyLinkedList();
        // System.out.println(l1);

        // l1.addFirst(50);
        // System.out.println(l1);

        // l1.addFirst(22);
        // System.out.println(l1);

        // l1.addLast(22);
        // System.out.println(l1);

        // l1.addLast(54);
        // System.out.println(l1);

        // l1.addFirst(32);
        // System.out.println(l1);

        // l1.addFirst(21);
        // System.out.println("end: " + l1);

        // l1.removeNode(22);
        // System.out.println(l1);

        // l1.clear();
        // System.out.println(l1);

        // Doubly LL:
        DoublyLinkedList l2 = new DoublyLinkedList();
        System.out.println(l2);

        l2.addFirst(10);
        System.out.println(l2);

        l2.addLast(20);
        System.out.println(l2);

        l2.addFirst(5);
        System.out.println(l2);

        l2.addLast(30);
        System.out.println("After inserts: " + l2);

        // reverse
        l2.reverse();
        System.out.println("After reverse: " + l2);

        // traverse forward & backward
        System.out.print("Traverse forward: ");
        l2.traverseForward();
        System.out.print("Traverse backward: ");
        l2.traverseBackward();

        // remove head
        l2.removeHead();
        System.out.println("After removeHead: " + l2);

        // remove tail
        l2.removeTail();
        System.out.println("After removeTail: " + l2);

        // remove by value
        l2.removeNode(20);
        System.out.println("After removeNode(20): " + l2);

        // insert at index
        l2.insertAt(1, 15);
        System.out.println("After insertAt(1, 15): " + l2);

        // contains
        System.out.println("Contains 15? " + l2.contains(15));
        System.out.println("Contains 100? " + l2.contains(100));

        // size
        System.out.println("Size: " + l2.size());

        // clear
        l2.clear();
        System.out.println("After clear: " + l2);

    }
}
