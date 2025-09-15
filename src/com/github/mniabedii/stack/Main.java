package com.github.mniabedii.stack;

public class Main {
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack();
        stack.push(10);
        stack.push(12);
        stack.push(15);
        System.out.println(stack);

        System.out.println("Pop Res: " + stack.pop());
        System.out.println(stack);

        System.out.println("Seek Res:" + stack.peek());
        
        System.out.println(stack);

        System.out.println(stack.size());
    }
}
