package com.github.mniabedii.queue;

import com.github.mniabedii.stack.ArrayStack;

/**
 * Demonstrates two different queue implementations using two stacks.
 * 
 * 1) StackQueueEnqueueCostly:
 * - Enqueue operation is O(n)
 * - Dequeue operation is O(1)
 * 
 * 2) StackQueueDequeueCostly:
 * - Enqueue operation is O(1)
 * - Dequeue operation is Amortized O(1)
 */
public class TwoStackQueue {

    /**
     * Approach 1: Costly Enqueue, Efficient Dequeue
     */
    public static class StackQueueEnqueueCostly {
        private ArrayStack mainStack = new ArrayStack();
        private ArrayStack helperStack = new ArrayStack();

        /**
         * Enqueue operation: O(n)
         * Move all elements to helper, insert new element, move back.
         */
        public void enqueue(int value) {
            // Step 1: Move everything to helper
            while (!mainStack.isEmpty()) {
                helperStack.push(mainStack.pop());
            }

            // Step 2: Push new element
            mainStack.push(value);

            // Step 3: Move back
            while (!helperStack.isEmpty()) {
                mainStack.push(helperStack.pop());
            }
        }

        /**
         * Dequeue: O(1), just pop from mainStack
         */
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue underflow");
            }
            return mainStack.pop();
        }

        /**
         * Peek: O(1)
         */
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue underflow");
            }
            return mainStack.peek();
        }

        public boolean isEmpty() {
            return mainStack.isEmpty();
        }
    }

    /**
     * Approach 2: Efficient Enqueue, Costly Dequeue (Amortized O(1))
     */
    public static class StackQueueDequeueCostly {
        private ArrayStack enqueueStack = new ArrayStack();
        private ArrayStack dequeueStack = new ArrayStack();

        /**
         * Enqueue operation: O(1), just push onto enqueueStack
         */
        public void enqueue(int value) {
            enqueueStack.push(value);
        }

        /**
         * Dequeue operation:
         * - If dequeueStack is empty, move all elements from enqueueStack
         * - Then pop from dequeueStack
         * 
         * Amortized O(1): each element is moved at most once.
         */
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            }
            if (dequeueStack.isEmpty()) {
                while (!enqueueStack.isEmpty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
            }
            return dequeueStack.pop();
        }

        /**
         * Peek operation, similar to dequeue but without removing
         */
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            }
            if (dequeueStack.isEmpty()) {
                while (!enqueueStack.isEmpty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
            }
            return dequeueStack.peek();
        }

        public boolean isEmpty() {
            return enqueueStack.isEmpty() && dequeueStack.isEmpty();
        }
    }
}
