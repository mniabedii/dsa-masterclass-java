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

        // Doubly LL:

    }
}
