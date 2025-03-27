package com.aiokleo.graph.adjacencyconversion;

import com.aiokleo.genetics.Generics;
import com.aiokleo.graph.breathfirstsearch.HasPath;
import com.aiokleo.graph.connectedcomponent.IsConnectedComponentCount;

import java.util.*;

public class ListToMatrix {
    public static void main(String[] args) {
        List<Object> visitedList = new ArrayList<>();
        System.out.println("Provide The Adjacency List Size as X * Y: ");

        System.out.print("X: ");
        Scanner x = new Scanner(System.in);
        int xSize = x.nextInt();

        System.out.print("Y: ");
        Scanner y = new Scanner(System.in);
        int ySize = y.nextInt();
        char[][] matrix = new char[xSize][ySize];

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                System.out.print("Provide the character for matrix[" + i + "][" + j + "]: ");
                Scanner scanner = new Scanner(System.in);
                char character = scanner.next().charAt(0);
                matrix[i][j] = character;
            }
        }

        Map<Character, List<Character>> graph = toAdjacencyList(matrix);
//        Map<Character, List<Character>> graph2 = toAdjacencyListCommon(matrix);
        System.out.println("Matrix \n" + Arrays.deepToString(matrix));
        System.out.println(graph);
        Set<Character> visited = new HashSet<>();
        System.out.println(HasPath.hasPathRecursive(graph, 'f', 'j', visited));
        System.out.println(IsConnectedComponentCount.connectedComponent(graph, visited, visitedList));
    }

    // For Undirected Graph
    public static Map<Character, List<Character>> toAdjacencyList(char[][] matrix) {
        Map<Character, List<Character>> adjacencyList = new HashMap<>();

        // Initialize the adjacency list
        for (char[] row : matrix) {
            for (char c : row) {
                adjacencyList.put(c, new ArrayList<>());
            }
        }

        // Populate the adjacency list based on the matrix
        for (char[] chars : matrix) {
            char sourceNode = chars[0];
            char targetNode = chars[1];

            adjacencyList.get(sourceNode).add(targetNode);
            adjacencyList.get(targetNode).add(sourceNode); // if the graph is undirected
        }

        return adjacencyList;
    }
}
