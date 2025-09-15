package com.github.mniabedii.stack;

import java.util.Stack;

public class JavaStackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek()); // 30
        System.out.println(stack.pop()); // 30
        System.out.println(stack.isEmpty());// false
    }

}
