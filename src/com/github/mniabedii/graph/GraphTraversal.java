package com.github.mniabedii.graph;

import java.util.*;

public class GraphTraversal {

    // Breadth-First Search (BFS)
    public static void bfs(GraphNode start) {
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            System.out.print(current.getName() + " -> ");

            for (GraphNode neighbor : current.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS) - iterative
    public static void dfsIterative(GraphNode start) {
        Set<GraphNode> visited = new HashSet<>();
        Stack<GraphNode> stack = new Stack<>();

        stack.push(start);

        System.out.print("DFS Iterative Traversal: ");
        while (!stack.isEmpty()) {
            GraphNode current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current.getName() + " -> ");

                // Push neighbors (reverse order to maintain order)
                List<GraphNode> neighbors = current.getNeighbors();
                Collections.reverse(neighbors);
                for (GraphNode neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
                Collections.reverse(neighbors); // restore order
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS) - recursive
    public static void dfsRecursive(GraphNode start) {
        Set<GraphNode> visited = new HashSet<>();
        System.out.print("DFS Recursive Traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private static void dfsHelper(GraphNode node, Set<GraphNode> visited) {
        visited.add(node);
        System.out.print(node.getName() + " -> ");

        for (GraphNode neighbor : node.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}
