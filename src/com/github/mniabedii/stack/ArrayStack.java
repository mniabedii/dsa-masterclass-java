package com.github.mniabedii.stack;

public class ArrayStack {
    private int[] stack = new int[100];
    private int top = 0;

    public boolean push(int data) {
        if (size() == stack.length) {
            System.out.println("Overflow");
            return false;
        }
        stack[top++] = data;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return stack[--top];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        for (int i = top - 1; i >= 0; i--) {
            s.append(stack[i]).append("\n__\n\n");
        }
        return s.toString();
    }
}
