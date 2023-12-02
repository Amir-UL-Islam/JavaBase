package com.aiokleo.graph.connectedcomponent;

import com.aiokleo.graph.Graphs;

import java.util.*;

class IsConnectedToAPath {
    public static void main(String[] args) {

        Set<Integer> visited = new HashSet<>();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Adding nodes and their adjacency lists
        graph.put(3, Collections.emptyList());
        graph.put(4, Collections.singletonList(6));
        graph.put(6, Arrays.asList(4, 5, 7, 8));
        graph.put(8, Collections.singletonList(6));
        graph.put(7, Collections.singletonList(6));
        graph.put(5, Collections.singletonList(6));
        graph.put(1, Collections.singletonList(2));
        graph.put(2, Collections.singletonList(1));

        printGraph(graph);
        if (IsConnectedToAPath.isConnected(graph, 4, visited)) {
            System.out.println("Graph is connected");
        } else {
            System.out.println("Graph is not connected");
        }


    }

    public static void printGraph(Map<Integer, List<Integer>> graph) {

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int node = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            System.out.print(node + ": ");
            for (Integer neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static Boolean isConnected(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited) {

        if (visited.contains(node)) return false;
        visited.add(node);

        for (Integer neighbor : graph.get(node)) {
            isConnected(graph, neighbor, visited);
        }
        return true;
    }

}
