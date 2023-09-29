package com.aiokleo.graph;

import java.util.*;

public class Graphs {
    public void printGraph(Map<Character, List<Character>> graph) {

        for (
                Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            char node = entry.getKey();
            List<Character> neighbors = entry.getValue();

            System.out.print(node + ": ");
            for (Character neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

    }

    public Map<Character, List<Character>> demoGraph() {
        Map<Character, List<Character>> graph = new HashMap<>();

        // Adding nodes and their adjacency lists
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Collections.singletonList('d'));
        graph.put('c', Collections.singletonList('e'));
        graph.put('d', Collections.emptyList());
        graph.put('e', Collections.singletonList('b'));
        graph.put('f', Collections.singletonList('d'));

        // Printing the graph
        this.printGraph(graph);

        return graph;
    }

    public Map<Character, List<Character>> acyclicOrNoCycleGraph() {
        Map<Character, List<Character>> graph = new HashMap<>();

//        f -----> g -----> h
//        |      ^
//        |     /
//        |    /
//        |   /
//        V  /
//        i <----- j
//        |
//        |
//        k

        // Adding nodes and their adjacency lists
        graph.put('f', Arrays.asList('g', 'i'));
        graph.put('g', Collections.singletonList('h'));
        graph.put('i', Arrays.asList('g', 'k'));
        graph.put('h', Collections.emptyList());
        graph.put('j', Collections.singletonList('i'));
        graph.put('k', Collections.emptyList());

        // Printing the graph
        this.printGraph(graph);
        return graph;
    }

    static class UndirectedGraphRepresentation {
        private final int numVertices; // Can be 6x6 or 8x8
        private final int[][] adjacencyMatrix;

        public UndirectedGraphRepresentation(int numVertices) {
            this.numVertices = numVertices;
            adjacencyMatrix = new int[numVertices][numVertices];
        }

        public void addEdge(int fromVertex, int toVertex) {
            adjacencyMatrix[fromVertex][toVertex] = 1;
            adjacencyMatrix[toVertex][fromVertex] = 1; // For an undirected graph
        }

        public void printGraph() {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(adjacencyMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static class DirectedGraphRepresentation {
        private int numVertices;
        private int[][] adjacencyMatrix;

        public DirectedGraphRepresentation(int numVertices) {
            this.numVertices = numVertices;
            adjacencyMatrix = new int[numVertices][numVertices];
        }

        public void addEdge(int fromVertex, int toVertex) {
            adjacencyMatrix[fromVertex][toVertex] = 1; // Indicates a directed edge from 'fromVertex' to 'toVertex'
        }

        public void printGraph() {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(adjacencyMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int numVertices = 5;
            DirectedGraphRepresentation graph = new DirectedGraphRepresentation(numVertices);

            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
            graph.addEdge(2, 4);

            System.out.println("Adjacency Matrix for Directed Graph:");
            graph.printGraph();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;


        UndirectedGraphRepresentation graph = new UndirectedGraphRepresentation(numVertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("Adjacency Matrix:");
        graph.printGraph();
    }
}


