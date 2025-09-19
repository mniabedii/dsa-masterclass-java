package com.github.mniabedii.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<GraphNode> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public GraphNode addNode(String name) {
        GraphNode node = new GraphNode(name);
        nodes.add(node);
        return node;
    }

    public void addEdge(GraphNode a, GraphNode b) {
        if (a.equals(b)) {
            System.out.println("Self-loops are not allowed: " + a.getName());
            return;
        }
        if (a.getNeighbors().contains(b) || b.getNeighbors().contains(a)) {
            System.out.println("Duplicate edge ignored between " + a.getName() + " and " + b.getName());
            return;
        }
        a.getNeighbors().add(b);
        b.getNeighbors().add(a);
    }

    public void printGraph() {
        for (GraphNode node : nodes) {
            System.out.print(node.name + " <-> ");
            for (GraphNode neighbor : node.neighbors) {
                System.out.print(neighbor.name + " ");
            }
            System.out.println();
        }
    }
}
