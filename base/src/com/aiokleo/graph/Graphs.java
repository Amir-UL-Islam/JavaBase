package com.aiokleo.graph;

import java.util.*;

public class Graphs {
    public static void printGraph(Map<Character, List<Character>> graph) {

        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            char node = entry.getKey();
            List<Character> neighbors = entry.getValue();

            System.out.print(node + ": ");
            for (Character neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }


    }


    public static int[][] adjacencyMatrix(int numVertices) {
        return new int[numVertices][numVertices];
    }

    public static void addUndirectedEdge(int[][] adjacencyMatrix, int fromVertex, int toVertex) {
        adjacencyMatrix[fromVertex][toVertex] = 1;
        adjacencyMatrix[toVertex][fromVertex] = 1; // Indicates a directed edge from 'fromVertex' to 'toVertex'
    }


    public static void addDirectedEdge(int[][] adjacencyMatrix, int fromVertex, int toVertex) {
        adjacencyMatrix[fromVertex][toVertex] = 1;
    }

    public static void printGraph(int numVertices, int[][] adjacencyMatrix) {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

//        public static void main(String[] args) {
//            int numVertices = 5;
//            DirectedGraphRepresentation graph = new DirectedGraphRepresentation(numVertices);
//
//            graph.addEdge(0, 1);
//            graph.addEdge(0, 2);
//            graph.addEdge(1, 3);
//            graph.addEdge(2, 4);
//
//            System.out.println("Adjacency Matrix for Directed Graph:");
//            graph.printGraph();
//        }
}



