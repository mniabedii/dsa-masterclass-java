package com.github.mniabedii.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        GraphNode n0 = graph.addNode("a");
        GraphNode n1 = graph.addNode("b");
        GraphNode n2 = graph.addNode("c");
        GraphNode n3 = graph.addNode("d");
        GraphNode n4 = graph.addNode("e");
        GraphNode n5 = graph.addNode("f");

        graph.addEdge(n0, n3);
        graph.addEdge(n1, n2);
        graph.addEdge(n2, n5);
        graph.addEdge(n5, n4);
        graph.addEdge(n0, n5);

        graph.printGraph();

        // Traversals:
        System.out.println("Stating traversal: ");
        GraphTraversal.bfs(n5);
        GraphTraversal.dfsIterative(n5);
        GraphTraversal.dfsRecursive(n5);
    }
}
